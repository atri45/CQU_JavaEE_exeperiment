package com.score.service;

import com.github.pagehelper.PageInfo;
import com.score.bean.Class;
import java.util.List;

public interface ClassService {

    List<Class> getClass(int teacherId);
    PageInfo<Class> getClass(int teacherId, int limit, int page);
}
