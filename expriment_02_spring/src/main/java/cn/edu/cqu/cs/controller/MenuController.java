package cn.edu.cqu.cs.controller;

import cn.edu.cqu.cs.entity.Menu;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Component
public class MenuController extends BaseController{

    @Override
    public void function(String s) {
        System.out.println("**************************************************************");
        System.out.println("                        System Menu");
        System.out.println("**************************************************************");

        List<Menu> menuList = new ArrayList<Menu>() {
            {
                add(new Menu("show menu", "menu"));
                add(new Menu("set current folder", "set -p <folderPath>"));
                add(new Menu("list current folder", "list (-p <order>)"));
                add(new Menu("view text file", "view -p <filePath>"));
                add(new Menu("copy file", "copy -p <sourcePath> <targetPath> (<bg>)"));
                add(new Menu("encrypt file", "encrypt -p <filePath>"));
                add(new Menu("decrypt file", "decrypt -p <sourcePath> <targetPath>"));
                add(new Menu("compress file", "compress -p <sourcePath> <targetPath>"));
                add(new Menu("decompress file", "decompress -p <sourcePath> <targetPath>"));
                add(new Menu("PS: order -> name, size, time, name_desc, size_desc, time_desc", ""));
            }
        };
        System.out.format("%-30s %-30s \n", "Function", "Command");
        for(Menu menu : menuList){
            System.out.format("%-30s %-30s \n", menu.getName(), menu.getCommand());
        }
    }

}
