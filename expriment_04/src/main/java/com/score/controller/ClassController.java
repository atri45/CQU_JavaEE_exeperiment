package com.score.controller;

import com.github.pagehelper.PageInfo;
import com.score.bean.ResultObject;
import com.score.bean.Class;
import com.score.bean.Teacher;
import com.score.service.ClassService;
import com.score.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/class")
@RestController
public class ClassController {
    @Autowired
    private ClassService classService;

    @RequestMapping("/selectClass")
    public ResultObject<List<Class>> selectClass(HttpServletRequest request) {
        Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
        List<Class> list = classService.getClass(teacher.getTeacherId());
        ResultObject<List<Class>> rs=new ResultObject<List<Class>>();
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("Query successfully");
        rs.setData(list);
        int total=list.size();
        Long a=Long.parseLong(String.valueOf(total));
        rs.setCount(a);
        return rs;
    }

    @RequestMapping("/getClass")
    public ResultObject<List<Class>> getClass(HttpServletRequest request, @RequestParam("limit") int limit, @RequestParam("page") int page) {
        Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
        PageInfo<Class> pageInfo = classService.getClass(teacher.getTeacherId(), limit, page);
        ResultObject<List<Class>> rs=new ResultObject<List<Class>>();
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("Query successfully");
        rs.setData(pageInfo.getList());
        rs.setCount(pageInfo.getTotal());
        return rs;
    }
}
