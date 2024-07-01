package com.score.service.impl;

import java.util.List;

import com.score.bean.ScoreFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.score.bean.ResultObject;
import com.score.bean.Score;
import com.score.bean.Student;
import com.score.dao.ScoreMapper;
import com.score.dao.StudentMapper;
import com.score.service.ScoreService;
import com.score.util.Constant;

@Service
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	private ScoreMapper scoreMapper;
	
	@Autowired
	private StudentMapper studentMapper;

	@Override
	public PageInfo<Score> getScore(int studentId, int limit, int page) {
		PageHelper.startPage(page, limit);
		List<Score> list = scoreMapper.selectByStudentId(studentId);
		PageInfo<Score> pageInfo = new PageInfo<Score>(list);
		return pageInfo;
	}

	@Override
	public PageInfo<Score> getAllScore(int teacherId, int limit, int page) {
		PageHelper.startPage(page, limit);
		List<Score> list = scoreMapper.selectByTeacherId(teacherId);
		PageInfo<Score> pageInfo = new PageInfo<Score>(list);
		return pageInfo;
	}

	@Override
	public PageInfo<Score> getScoreByFilter(ScoreFilter scoreFilter, int limit, int page) {
		PageHelper.startPage(page, limit);
		List<Score> list = scoreMapper.selectByFilter(scoreFilter);
		PageInfo<Score> pageInfo = new PageInfo<Score>(list);
		return pageInfo;
	}

	@Override
	public ResultObject<Object> insertScore(Score score) {
		ResultObject<Object> rs = new ResultObject<Object>();
		Integer total = scoreMapper.insert(score);
		if (null == total || 0 == total) {
			rs.setCode(Constant.HASE_RETUEN_CODE);
			rs.setMsg("Insert unsuccessfully");
		} else {
			rs.setCode(Constant.SUCCESS_RETUEN_CODE);
			rs.setMsg("Insert successfully");
		}
		return rs;
	}

	@Override
	public Integer updateScore(Score score) {
		return scoreMapper.updateByPrimaryKey(score);
	}

	@Override
	public Integer deleteScore(int scoreId) {
		return scoreMapper.deleteById(scoreId);
	}

	@Override
	public List<Score> getBatchAdd(int teacherId) {
		return scoreMapper.selectBatchAdd(teacherId);
	}

	@Override
	public int deleteByTeacherId(int teacherId) {
		return scoreMapper.deleteByTeacherId(teacherId);
	}

}
