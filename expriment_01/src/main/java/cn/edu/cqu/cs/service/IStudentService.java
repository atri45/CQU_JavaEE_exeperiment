package cn.edu.cqu.cs.service;

import cn.edu.cqu.cs.entity.Student;
import cn.edu.cqu.cs.mapper.IStudentDao;

import java.util.List;

public interface IStudentService {

    public long add(Student student);
    public void update(Student student);
    public void delete(long id);

    public Student find(long id);

    public List<Student> findAll();

    public long count();

}
