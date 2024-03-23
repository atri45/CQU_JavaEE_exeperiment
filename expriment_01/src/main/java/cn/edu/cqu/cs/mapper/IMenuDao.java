package cn.edu.cqu.cs.mapper;

import cn.edu.cqu.cs.entity.Menu;
import cn.edu.cqu.cs.entity.Student;

import java.util.List;

public interface IMenuDao {
    public List<Menu> findAll();
}
