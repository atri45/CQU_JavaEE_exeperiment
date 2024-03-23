package cn.edu.cqu.cs.controller;

import cn.edu.cqu.cs.entity.BaseEntity;
import cn.edu.cqu.cs.entity.Menu;
import cn.edu.cqu.cs.service.IMenuService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuController implements BaseController{

    private IMenuService menuService;

    @Override
    public void add() {

    }

    @Override
    public void update(long id) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public BaseEntity find(long id) {
        return null;
    }

    public List<BaseEntity> findAll() {
        List<Menu> menuList =menuService.findAll();
        List<BaseEntity> entitys = new ArrayList<>();
        for(Menu menu: menuList){
            entitys.add(menu);
        }
        return entitys;
    }

    @Override
    public long count() {
        return 0;
    }

    /**
     * 展示主菜单
     */
    @Override
    public void menu() {

        System.out.println("********************************************");
        System.out.println("                   系统主页");
        System.out.println("********************************************");

        List<BaseEntity> menuList = findAll();
        view(menuList);
    }

    /**
     * 展示给定的菜单集合
     * @param menuList
     */
    @Override
    public void view(List<BaseEntity> menuList){

        System.out.format("%6s %6s %20s \n", "序号", "名称", "命令");
        for(BaseEntity entity : menuList){
            Menu menu = (Menu) entity;
            System.out.format("%6s %6s %20s \n", menu.getId(), menu.getName(), menu.getCommand());
        }
    }

}
