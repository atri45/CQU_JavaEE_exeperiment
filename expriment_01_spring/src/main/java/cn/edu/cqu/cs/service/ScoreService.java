package cn.edu.cqu.cs.service;

import cn.edu.cqu.cs.entity.Score;
import cn.edu.cqu.cs.mapper.ScoreDao;
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
public class ScoreService {

    @Autowired
    private ScoreDao scoreDao = new ScoreDao();

    public void create() { scoreDao.create(); }

    public void insert(Score score) {
        scoreDao.insert(score);
    }

    public void update(Score score) {
        scoreDao.update(score);
    }

    public void delete(long id) {
        scoreDao.delete(id);
    }

    public Score query(long id) {
        return scoreDao.query(id);
    }

    public List<Score> queryAll() {
        return scoreDao.queryAll();
    }

}
