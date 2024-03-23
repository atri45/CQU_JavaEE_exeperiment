package cn.edu.cqu.cs.service;

import cn.edu.cqu.cs.entity.Course;
import cn.edu.cqu.cs.mapper.CourseDao;
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
public class CourseService {

    @Autowired
    private CourseDao courseDao = new CourseDao();

    public void create() { courseDao.create(); }

    public void insert(Course course) {
        courseDao.insert(course);
    }

    public void update(Course course) {
        courseDao.update(course);
    }

    public void delete(long id) {
        courseDao.delete(id);
    }

    public Course query(long id) {
        return courseDao.query(id);
    }

    public List<Course> queryAll() {
        return courseDao.queryAll();
    }

}
