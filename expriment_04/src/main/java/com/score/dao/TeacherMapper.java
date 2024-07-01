package com.score.dao;

import com.score.bean.Teacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMapper {
    Teacher selectById(int teacherId);
}
