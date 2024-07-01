package com.score.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import com.score.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.score.service.ScoreService;
import com.score.util.Constant;

@RequestMapping("/score")
@RestController
public class ScoreController {

	@Autowired
	private ScoreService scoreService;
	
    @RequestMapping("/addScore")
    public ResultObject<Object> addScore(Score score) {
		score.setComprehensiveScore((score.getRegularScore() + score.getMidScore() + score.getExperimentalScore() + score.getFinalScore())/4);
    	ResultObject<Object> rs=scoreService.insertScore(score);
    	return rs;
    }
	
    @RequestMapping("/updateScore")
    public ResultObject<Object> updateScore(Score score) {
		score.setComprehensiveScore((score.getRegularScore() + score.getMidScore() + score.getExperimentalScore() + score.getFinalScore())/4);
    	Integer total=scoreService.updateScore(score);

    	ResultObject<Object> rs=new ResultObject<Object>();
    	if(null==total||0==total) {
    		rs.setCode(Constant.FAILURE_RETUEN_CODE);
    		rs.setMsg("Update unsuccessfully");
    	}else {
    		rs.setCode(Constant.SUCCESS_RETUEN_CODE);
    		rs.setMsg("Update successfully");
    	}
    	return rs;
    }
    
    @RequestMapping("/deleteScore")
    public ResultObject<Object> deleteScore(Score score) {
    	Integer total=scoreService.deleteScore(score.getScoreId());
    	
    	ResultObject<Object> rs=new ResultObject<Object>();
    	if(null==total||0==total) {
    		rs.setCode(Constant.FAILURE_RETUEN_CODE);
    		rs.setMsg("Delete unsuccessfully");
    	}else {
    		rs.setCode(Constant.SUCCESS_RETUEN_CODE);
    		rs.setMsg("Delete successfully");
    	}
    	return rs;
    }

    @RequestMapping("/getMyScore")
    public ResultObject<List<Score>> getMyScore(HttpServletRequest request,@RequestParam("limit") int limit,@RequestParam("page") int page) {
    	Student student = (Student)request.getSession().getAttribute("student");
		PageInfo<Score> pageInfo = scoreService.getScore(student.getStudentId(), limit, page);
    	ResultObject<List<Score>> rs=new ResultObject<List<Score>>();
    	rs.setCode(Constant.SUCCESS_RETUEN_CODE);
    	rs.setMsg("Query successfully");
		rs.setData(pageInfo.getList());
		rs.setCount(pageInfo.getTotal());
    	return rs;
    }

	@RequestMapping("/getAllScore")
	public ResultObject<List<Score>> getAllScore(HttpServletRequest request,@RequestParam("limit") int limit,@RequestParam("page") int page) {
		Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
		PageInfo<Score> pageInfo=scoreService.getAllScore(teacher.getTeacherId(),limit, page);
		ResultObject<List<Score>> rs=new ResultObject<List<Score>>();
		List<Score> list=pageInfo.getList();
		rs.setCode(Constant.SUCCESS_RETUEN_CODE);
		rs.setMsg("Query successfully");
		rs.setData(list);
		rs.setCount(pageInfo.getTotal());
		return rs;
	}

	@RequestMapping("/getScoreByFilter")
	public ResultObject<List<Score>> getScoreByFilter(String courseName, String studentName, HttpServletRequest request, @RequestParam("limit") int limit,@RequestParam("page") int page) {
		Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
		ScoreFilter scoreFilter = new ScoreFilter();
		scoreFilter.setTeacherId(teacher.getTeacherId());
		scoreFilter.setCourseName(courseName);
		scoreFilter.setStudentName(studentName);
		PageInfo<Score> pageInfo=scoreService.getScoreByFilter(scoreFilter, limit, page);
		ResultObject<List<Score>> rs=new ResultObject<List<Score>>();
		List<Score> list=pageInfo.getList();
		rs.setCode(Constant.SUCCESS_RETUEN_CODE);
		rs.setMsg("Query successfully");
		rs.setData(list);
		rs.setCount(pageInfo.getTotal());
		return rs;
	}

	@RequestMapping("/batchAddScore")
	public ResultObject<Object> batchAddScore(HttpServletRequest request) {
		Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
		scoreService.deleteByTeacherId(teacher.getTeacherId());
		List<Score> scoreList = scoreService.getBatchAdd(teacher.getTeacherId());
		for (Score score: scoreList) {
			Random random = new Random();
			int RegularScore = random.nextInt(41) + 60;
			int MidScore = random.nextInt(41) + 60;
			int ExperimentalScore = random.nextInt(41) + 60;
			int FinalScore = random.nextInt(41) + 60;
			int ComprehensiveScore = (RegularScore + MidScore + ExperimentalScore + FinalScore) / 4;
			score.setRegularScore(RegularScore);
			score.setMidScore(MidScore);
			score.setExperimentalScore(ExperimentalScore);
			score.setFinalScore(FinalScore);
			score.setComprehensiveScore(ComprehensiveScore);
			scoreService.insertScore(score);
		}
		ResultObject<Object> rs=new ResultObject<Object>();
		if(scoreList.isEmpty()) {
			rs.setCode(Constant.FAILURE_RETUEN_CODE);
		}else {
			rs.setCode(Constant.SUCCESS_RETUEN_CODE);
		}
		return rs;
	}
}
