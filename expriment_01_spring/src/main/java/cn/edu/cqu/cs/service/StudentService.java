package cn.edu.cqu.cs.service;

import cn.edu.cqu.cs.entity.Student;
import cn.edu.cqu.cs.mapper.StudentDao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao = new StudentDao();

    public void create() { studentDao.create(); }

    public void insert(Student student) {
        studentDao.insert(student);
    }

    public void update(Student student) {
        studentDao.update(student);
    }

    public void delete(long id) {
        studentDao.delete(id);
    }

    public Student query(long id) {
        return studentDao.query(id);
    }

    public List<Student> queryAll() {
        return studentDao.queryAll();
    }

}
