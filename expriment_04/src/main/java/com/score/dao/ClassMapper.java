package com.score.dao;

import com.score.bean.Class;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassMapper {

    List<Class> getClass(int teacherId);
}
