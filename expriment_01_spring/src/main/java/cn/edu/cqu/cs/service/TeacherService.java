package cn.edu.cqu.cs.service;

import cn.edu.cqu.cs.entity.Teacher;
import cn.edu.cqu.cs.mapper.TeacherDao;
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
public class TeacherService {

    @Autowired
    private TeacherDao teacherDao = new TeacherDao();

    public void create() { teacherDao.create(); }

    public void insert(Teacher teacher) {
        teacherDao.insert(teacher);
    }

    public void update(Teacher teacher) {
        teacherDao.update(teacher);
    }

    public void delete(long id) {
        teacherDao.delete(id);
    }

    public Teacher query(long id) {
        return teacherDao.query(id);
    }

    public List<Teacher> queryAll() {
        return teacherDao.queryAll();
    }

}