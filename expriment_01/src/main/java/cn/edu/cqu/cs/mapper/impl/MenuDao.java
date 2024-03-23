package cn.edu.cqu.cs.mapper.impl;

import cn.edu.cqu.cs.entity.Menu;
import cn.edu.cqu.cs.mapper.IMenuDao;

import java.util.ArrayList;
import java.util.List;

public class MenuDao implements IMenuDao {

    private List<Menu> menuList = new ArrayList<Menu>() {
        {
            add(new Menu(1, "学生管理", "manage -t student"));
            add(new Menu(2, "菜单管理","manage -t menu"));
        }
    };

    @Override
    public List<Menu> findAll() {
        return menuList;
    }
}
