package cn.edu.cqu.cs;

import cn.edu.cqu.cs.config.AppConfiguration;
import cn.edu.cqu.cs.controller.*;
import org.apache.commons.cli.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    /**
     * Spring容器 , 在 initSpringContainer() 方法中初始化
     */
    private static ApplicationContext container ;

    /**
     * 控制器 Map , 在 initController () 方法中初始化
     */
    private static Map<String, BaseController> controllerMap;

    /**
     * 命令行工具-命令集合, 在initCommandTool() 方法中初始化
     */
    private static Options options;

    /**
     * 命令行工具-命令集合, 在 initCommandTool()方法中初始化
     */
    private static CommandLineParser parser;

    private static final SetController setController = new SetController();

    public static void main(String[] args) {

        // 初始化
        init();

        // 显示系统主页
        String command = "menu";
        String[] arg = command.split(" ");
        executeCommand(arg);

        // 接收指令
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("\n" + setController.getDirPath() + ">");
            command = scanner.nextLine();
            if (command.equals("exit")) {
                System.out.println("Exit the system.");
                System.exit(0);
            }
            arg = command.split(" ");
            executeCommand(arg);
        }
    }

    /**
     * 系统初始化
     */
    private static void init(){
        initSpringContainer();
        initController();
        initCommandTool();
    }

    /**
     *  初始化 Spring 容器
     */
    public static void initSpringContainer(){
        container = new AnnotationConfigApplicationContext(AppConfiguration.class);
    }

    /**
     * 初始化所有 Controller
     */
    public static void initController(){
        controllerMap = new HashMap<>();
        controllerMap.put("menu", initMenuController());
        controllerMap.put("set", initSetController());
        controllerMap.put("list", initListController());
        controllerMap.put("view", initViewController());
        controllerMap.put("copy", initCopyController());
        controllerMap.put("encrypt", initEncryptController());
        controllerMap.put("decrypt", initDecryptController());
        controllerMap.put("compress", initCompressController());
        controllerMap.put("decompress", initDecompressController());
    }

    /**
     * 初始化 MenuController
     */
    public static MenuController initMenuController(){

        return container.getBean(MenuController.class);
    }

    /**
     * 初始化 SetDirController
     */
    public static SetController initSetController(){

        return setController;
    }

    /**
     * 初始化 ListController
     */
    public static ListController initListController(){

        return container.getBean(ListController.class);
    }

    /**
     * 初始化 ViewController
     */
    public static ViewController initViewController(){

        return container.getBean(ViewController.class);
    }

    /**
     * 初始化 CopyController
     */
    public static CopyController initCopyController(){

        return container.getBean(CopyController.class);
    }

    /**
     * 初始化 EncryptController
     */
    public static EncryptController initEncryptController(){

        return container.getBean(EncryptController.class);
    }

    /**
     * 初始化 DecryptController
     */
    public static DecryptController initDecryptController(){

        return container.getBean(DecryptController.class);
    }

    /**
     * 初始化 CompressController
     */
    public static CompressController initCompressController(){

        return container.getBean(CompressController.class);
    }

    /**
     * 初始化 DecompressController
     */
    public static DecompressController initDecompressController(){

        return container.getBean(DecompressController.class);
    }

    /**
     *  初始化 命令行工具
     */
    public static void initCommandTool(){

        options = new Options();

        Option param = new Option("p", "param", true, "parameter");
        param.setRequired(false);
        options.addOption(param);

        parser = new DefaultParser();
    }

    /**
     * 执行命令
     * @param args
     */
    public static void executeCommand(String[] args)  {
        HelpFormatter hf = new HelpFormatter();
        hf.setWidth(110);
        try {
            CommandLine commandLine = parser.parse(options, args);
            dispatcher(commandLine);
        }
        catch (ParseException e) {
            System.out.println("Unsupported command format.");
        }
    }

    /**
     * 命令请求分发
     *
     * @param commandLine
     */
    private static void dispatcher(CommandLine commandLine){
        BaseController controller = null;
        try {

            String controllerName = commandLine.getArgs()[0];
            controller = controllerMap.get(controllerName);
            String[] params = commandLine.getOptionValues("p");
            assert controller != null;

            if (params != null) {
                if (params.length == 1) {
                    if (controllerName.equals("view") || controllerName.equals("list")) {
                        controller.function(setController.getDirPath(), params[0]);
                    }
                    else {
                        StringBuilder stringBuilder = new StringBuilder(params[0]);
                        List<String> paramList = commandLine.getArgList();
                        if (paramList.size() > 1) {
                            for (int i = 1; i < paramList.size(); i++) {
                                stringBuilder.append(",").append(paramList.get(i));
                            }
                        }
                        controller.function(stringBuilder.toString());
                    }
                }
            }
            else {
                if (!controllerName.equals("list") && !controllerName.equals("menu")) {
                    System.out.println("Unsupported command format.");
                }
                else {
                    controller.function(setController.getDirPath());
                }
            }
        } catch (RuntimeException e) {
            System.out.println("Unsupported command format.");
        }
    }

}