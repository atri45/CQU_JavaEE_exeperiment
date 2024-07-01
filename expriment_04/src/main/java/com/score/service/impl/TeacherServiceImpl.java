package com.score.service.impl;

import com.score.bean.Teacher;
import com.score.dao.TeacherMapper;
import com.score.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher selectById(int teacherId) {
        return teacherMapper.selectById(teacherId);
    }
}
