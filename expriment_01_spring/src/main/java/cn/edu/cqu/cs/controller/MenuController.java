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
    /**
     * 展示主菜单
     */
    @Override
    public void menu() {
        System.out.println("**************************************************");
        System.out.println("                  System Menu");
        System.out.println("**************************************************");

        List<Menu> menuList = new ArrayList<Menu>() {
            {
                add(new Menu("show menu", "manage -c menu"));
                add(new Menu("simulate teaching", "manage -c simulation"));
                add(new Menu("query score", "manage -c query"));
            }
        };
        System.out.format("%-25s %-30s \n", "Function", "Command");
        for(Menu menu : menuList){
            System.out.format("%-25s %-30s \n", menu.getName(), menu.getCommand());
        }
    }

}
