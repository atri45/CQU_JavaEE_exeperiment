package com.score.service;

import com.github.pagehelper.PageInfo;
import com.score.bean.ResultObject;
import com.score.bean.Score;
import com.score.bean.ScoreFilter;
import com.score.bean.Student;

import java.util.List;

public interface ScoreService {
	PageInfo<Score> getScore(int studentId,int limit,int page);
	PageInfo<Score> getAllScore(int teacherId,int limit,int page);

	PageInfo<Score> getScoreByFilter(ScoreFilter scoreFilter, int limit, int page);
	ResultObject<Object> insertScore(Score score);

	Integer updateScore(Score score);

	Integer deleteScore(int scoreId);

	List<Score> getBatchAdd(int teacherId);

	int deleteByTeacherId(int teacherId);
}
