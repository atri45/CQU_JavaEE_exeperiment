package cn.edu.cqu.cs.service.impl;

import cn.edu.cqu.cs.CommandTool;
import cn.edu.cqu.cs.entity.Student;
import cn.edu.cqu.cs.mapper.IStudentDao;
import cn.edu.cqu.cs.service.IStudentService;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentServiceImpl implements IStudentService {

    private IStudentDao studentDao;

    @Override
    public long add(Student student) {

        long id = studentDao.add(student);
        System.out.println("添加Student成功...");
        return id;
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Student find(long id) {
        return studentDao.find(id);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public long count() {

        return studentDao.count();
    }

}
