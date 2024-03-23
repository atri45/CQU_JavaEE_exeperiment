package cn.edu.cqu.cs.controller;

import cn.edu.cqu.cs.entity.BaseEntity;
import cn.edu.cqu.cs.entity.Student;

import java.util.List;

public interface BaseController {

    public void add();
    public void update(long id);
    public void delete(long id);

    public BaseEntity find(long id);

    public List<BaseEntity> findAll();

    public long count();

    public void menu();
    public void view(List<BaseEntity> entities);

}

