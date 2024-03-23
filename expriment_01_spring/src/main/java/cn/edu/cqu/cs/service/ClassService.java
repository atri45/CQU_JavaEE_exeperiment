package cn.edu.cqu.cs.service;

import cn.edu.cqu.cs.entity.Class;
import cn.edu.cqu.cs.mapper.ClassDao;
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
public class ClassService {

    @Autowired
    private ClassDao classDao = new ClassDao();

    public void create() { classDao.create(); }

    public void insert(Class classObj) {
        classDao.insert(classObj);
    }

    public void update(Class classObj) {
        classDao.update(classObj);
    }

    public void delete(long id) {
        classDao.delete(id);
    }

    public Class query(long id) {
        return classDao.query(id);
    }

    public List<Class> queryAll() {
        return classDao.queryAll();
    }

}
