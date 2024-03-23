package cn.edu.cqu.cs.service;

import cn.edu.cqu.cs.entity.QueryResult;
import cn.edu.cqu.cs.mapper.QueryDao;
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
public class QueryService {

    @Autowired
    private QueryDao queryDao = new QueryDao();

    public List<QueryResult> queryStudents(int id) {
        return queryDao.queryStudents(id);
    }

    public List<QueryResult> queryCourses(int id, int order) {
        return queryDao.queryCourses(id, order);
    }

    public List<QueryResult> queryClasses(int id, int order) {
        return queryDao.queryClasses(id, order);
    }
}
