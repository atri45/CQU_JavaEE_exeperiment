package com.score.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.score.dao.ClassMapper;
import com.score.bean.Class;
import com.score.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassMapper classMapper;

    @Override
    public List<Class> getClass(int teacherId){
        return classMapper.getClass(teacherId);
    }

    @Override
    public PageInfo<Class> getClass(int teacherId, int limit, int page){
        PageHelper.startPage(page, limit);
        List<Class> list = classMapper.getClass(teacherId);
        PageInfo<Class> pageInfo = new PageInfo<Class>(list);
        return pageInfo;
    }
}
