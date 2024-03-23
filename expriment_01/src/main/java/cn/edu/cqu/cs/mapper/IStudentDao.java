package cn.edu.cqu.cs.mapper;

import cn.edu.cqu.cs.entity.Student;

import java.util.List;

public interface IStudentDao {

    public long add(Student student);
    public void update(Student student);
    public void delete(long id);

    public Student find(long id);

    public List<Student> findAll();

    public long count();
}
