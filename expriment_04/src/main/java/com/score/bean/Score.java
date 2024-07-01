package com.score.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Score implements Serializable {
    //学生id，课程id，平时成绩，期中成绩，实验成绩，期末成绩，综合成绩
    private Integer scoreId;

    private Integer studentId;

    private String studentName;

    private String courseName;

    private Integer classId;

    private Integer regularScore;

    private Integer midScore;

    private Integer experimentalScore;

    private Integer finalScore;

    private Integer comprehensiveScore;

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getRegularScore() {
        return regularScore;
    }

    public void setRegularScore(Integer regularScore) {
        this.regularScore = regularScore;
    }

    public Integer getMidScore() {
        return midScore;
    }

    public void setMidScore(Integer midScore) {
        this.midScore = midScore;
    }

    public Integer getExperimentalScore() {
        return experimentalScore;
    }

    public void setExperimentalScore(Integer experimentalScore) {
        this.experimentalScore = experimentalScore;
    }

    public Integer getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Integer finalScore) {
        this.finalScore = finalScore;
    }

    public Integer getComprehensiveScore() {
        return comprehensiveScore;
    }

    public void setComprehensiveScore(Integer comprehensiveScore) {
        this.comprehensiveScore = comprehensiveScore;
    }
}