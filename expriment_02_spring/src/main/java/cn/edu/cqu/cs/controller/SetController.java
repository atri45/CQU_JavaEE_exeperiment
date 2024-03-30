package cn.edu.cqu.cs.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.File;

@Getter
@Setter
@NoArgsConstructor
@Component
public class SetController extends BaseController{
    private String folderPath = "";

    @Override
    public void show() {
        System.out.println("Set Directory Path successfully!");
    }

    @Override
    public void function(String folderPath) {
        File folder = new File(folderPath);
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Invalid folder path：" + folderPath);
            return;
        }
        this.folderPath = folderPath;
        show();
    }

    public String getDirPath() {
        return folderPath;
    }
}
