package com.score.dao;

import com.score.bean.Score;
import com.score.bean.ScoreFilter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScoreMapper {

    int deleteById(Integer scoreId);

    int insert(Score record);

    List<Score> selectByStudentId(int studentId);

    List<Score> selectByTeacherId(int teacherId);

    List<Score> selectByFilter(ScoreFilter scoreFilter);

    List<Score> selectBatchAdd(int teacherId);

    int deleteByTeacherId(int teacherId);

    int updateByPrimaryKey(Score record);

}