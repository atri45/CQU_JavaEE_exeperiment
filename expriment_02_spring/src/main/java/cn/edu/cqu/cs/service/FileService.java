package cn.edu.cqu.cs.service;

import cn.edu.cqu.cs.entity.MyFile;
import org.springframework.util.StreamUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class FileService {
    static int copiedFiles;

    static int totalFiles;

    static boolean backGround;

    private static final String AES_ALGORITHM = "AES";
    private static final String ENCRYPTED_FILE_EXTENSION = ".encrypted";

    // Encryption key
    private static final String SECRET_KEY = "E3q/2y2U4RO6Hi4q1Wv+RXWZ7pfheF/3";

    // list all files and folders in the current folder
    public static List<MyFile> list(String dirPath, String sort) {
        try {
            File dir = new File(dirPath);
            File[] files = dir.listFiles();
            List<MyFile> results = new ArrayList<>();
            if (files != null) {

                // get list of MyFile
                for (File file : files) {
                    MyFile myFile = new MyFile(file.getName(), getSize(file), new Timestamp(file.lastModified()).toString());
                    results.add(myFile);
                }

                // Sort the list based on sort parameter
                switch (sort) {
                    case "name" -> results.sort(Comparator.comparing(MyFile::getFirstChar));
                    case "size" -> results.sort(Comparator.comparingLong(MyFile::getSize));
                    case "time" -> results.sort(Comparator.comparing(MyFile::getTime));
                    case "name_desc" -> results.sort(Comparator.comparing(MyFile::getFirstChar).reversed());
                    case "size_desc" -> results.sort(Comparator.comparingLong(MyFile::getSize).reversed());
                    case "time_desc" -> results.sort(Comparator.comparing(MyFile::getTime).reversed());
                    default -> {}
                }
            }
            return results;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static long getSize(File folder) {
        long size = 0;
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        size += file.length();
                    } else {
                        size += getSize(file);
                    }
                }
            }
        } else {
            size = folder.length();
        }
        return size;
    }

    public static void view(String folderPath, String fileName) {
        try {
            File folder = new File(folderPath);
            File[] files = folder.listFiles();
            boolean exist = false;

            if (files != null) {
                for (File file : files) {
                    if (file.getName().equals(fileName)) {
                        view(file);
                        exist = true;
                        break;
                    }
                }
            }
            else {
                System.out.println("File doesn't exist：" + fileName);
            }
            if (!exist) {
                System.out.println("File doesn't exist：" + fileName);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("View file failed：" + fileName);
        }
    }

    public static void view(File file) {
        try {
            if (file.exists()) {
                if (!file.canRead()) {
                    System.out.println("The file is not readable: " + file.getName());
                    return;
                }
                if (!file.isFile()) {
                    System.out.println("The file is not a regular file: " + file.getName());
                    return;
                }

                // Read the file content and print it to the command line
                System.out.println(file.getName() + ":\n");
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();
            } else {
                System.out.println("File doesn't exist: " + file.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to view file: " + file.getName());
        }
    }

    public static void copy(String sourcePath, String targetPath) {
        File sourceFile = new File(sourcePath);
        File destinationFile = new File(targetPath);
        copiedFiles = 0;
        totalFiles = countFilesInDirectory(sourceFile);
        backGround = false;
        long startTime = System.currentTimeMillis();

        try {
            if (sourceFile.isDirectory()) {
                copyDirectory(sourceFile, destinationFile);
            } else {
                String fileExtension = getFileExtension(sourceFile);
                copyFile(sourceFile, destinationFile);
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Copy completed, total time:" + (endTime - startTime) + "ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void threadCopy(String sourcePath, String targetPath) {
        File sourceFile = new File(sourcePath);
        File destinationFile = new File(targetPath);
        copiedFiles = 0;
        totalFiles = countFilesInDirectory(sourceFile);
        backGround = true;
        long startTime = System.currentTimeMillis();

        Thread copyThread = new Thread(() -> {
            try {
                if (sourceFile.isDirectory()) {
                    copyDirectory(sourceFile, destinationFile);
                } else {
                    String fileExtension = getFileExtension(sourceFile);
                    copyFile(sourceFile, destinationFile);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Copy completed, total time: " + (endTime - startTime) + "ms");
        });
        copyThread.start();
    }


    public static void copyDirectory(File source, File target) throws IOException {
        if (!target.exists()) {
            target.mkdirs();
        }

        File[] files = source.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    copyDirectory(file, new File(target, file.getName()));
                } else {
                    copyFile(file, new File(target, file.getName()));
                    copiedFiles++;
                    if (!backGround) {
                        System.out.println("Copying: " + copiedFiles + "/" + totalFiles);
                    }
                }
            }
        }
    }

    public static int countFilesInDirectory(File directory) {
        int count = 0;
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    count += countFilesInDirectory(file);
                } else {
                    count++;
                }
            }
        }
        return count;
    }

    public static void copyFile(File source, File target) throws IOException {
        try (InputStream in = new FileInputStream(source);
             OutputStream out = new FileOutputStream(target)) {

            byte[] buffer = new byte[1024];
            int length;

            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
    }

    private static String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return "";
        }
        return name.substring(lastIndexOf);
    }

    public static void encrypt(String filePath) {
        try {
            byte[] fileContent = Files.readAllBytes(Paths.get(filePath));

            // Create AES encryptor
            SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), AES_ALGORITHM);
            Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // encrypt
            byte[] encryptedContent = cipher.doFinal(fileContent);
            String encryptedFilePath = filePath + ENCRYPTED_FILE_EXTENSION;
            FileOutputStream outputStream = new FileOutputStream(encryptedFilePath);
            outputStream.write(encryptedContent);
            outputStream.close();

            System.out.println("Encrypt file successfully：" + encryptedFilePath);
        } catch (Exception e) {
            System.out.println("Encrypt file failed:" + e);
        }
    }

    public static void decrypt(String encryptedFilePath, String decryptedFilePath) {
        try {
        // read encryption content
        byte[] encryptedContent = Files.readAllBytes(Paths.get(encryptedFilePath));

        // Create AES encryptor
        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), AES_ALGORITHM);
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        // decrypt
        byte[] decryptedContent = cipher.doFinal(encryptedContent);
        FileOutputStream outputStream = new FileOutputStream(decryptedFilePath);
        outputStream.write(decryptedContent);
        outputStream.close();

        System.out.println("Decrypt file successfully：" + decryptedFilePath);
        } catch (Exception e) {
            System.out.println("Decrypt file failed:" + e);
        }
    }

    public static void compress(String sourcePath, String zipFilePath) {
        File sourceFile = new File(sourcePath);
        if (sourceFile.isFile()) {

            compressFile(sourcePath, zipFilePath);
            System.out.println("Compress file successfully!");
        } else if (sourceFile.isDirectory()) {

            compressFolder(sourcePath, zipFilePath);
            System.out.println("Compress file successfully!");
        }
        else {
            System.out.println("Source path is neither a file nor a directory.");
        }
    }

    public static void compressFile(String sourceFilePath, String zipFilePath) {
        try (FileInputStream fis = new FileInputStream(sourceFilePath);
             ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFilePath))) {

            ZipEntry zipEntry = new ZipEntry(new File(sourceFilePath).getName());
            zos.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, length);
            }

            zos.closeEntry();
        } catch (IOException e) {
            System.out.println("Compress file failed:" + e);
        }
    }

    public static void compressFolder(String sourceFolderPath, String zipFilePath) {
        try (FileOutputStream fos = new FileOutputStream(zipFilePath);
             ZipOutputStream zos = new ZipOutputStream(fos)) {
            Path sourcePath = Paths.get(sourceFolderPath);
            Files.walk(Paths.get(sourceFolderPath))
                    .filter(Files::isRegularFile)
                    .forEach(file -> {
                        try {
                            // compress
                            Path relativePath = sourcePath.relativize(file);
                            ZipEntry zipEntry = new ZipEntry(relativePath.toString());
                            zos.putNextEntry(zipEntry);
                            FileInputStream fis = new FileInputStream(file.toFile());
                            StreamUtils.copy(fis, zos);
                            zos.closeEntry();
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (Exception e) {
        System.out.println("Compress file failed:" + e);
        }
    }

    public static void decompress(String zipFilePath, String decompressFolderPath) {
        try (FileInputStream fis = new FileInputStream(zipFilePath);
             ZipInputStream zis = new ZipInputStream(fis)) {

            ZipEntry zipEntry;
            while ((zipEntry = zis.getNextEntry()) != null) {
                String filePath = decompressFolderPath + File.separator + zipEntry.getName();
                if (!zipEntry.isDirectory()) {
                    File parent = new File(filePath).getParentFile();
                    if (!parent.exists() && !parent.mkdirs()) {
                        throw new IllegalStateException("Couldn't create directory " + parent);
                    }
                    FileOutputStream fos = new FileOutputStream(filePath);
                    StreamUtils.copy(zis, fos);
                    fos.close();
                }
                zis.closeEntry();
            }
            System.out.println("Decompress file successfully!");
        } catch (Exception e) {
        System.out.println("Decompress file failed:" + e);
    }
    }
}
