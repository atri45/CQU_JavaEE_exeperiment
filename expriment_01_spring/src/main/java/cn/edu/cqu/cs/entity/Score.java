package cn.edu.cqu.cs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score {
    //学生id，课程id，平时成绩，期中成绩，实验成绩，期末成绩，综合成绩,成绩生成时间
    private int studentId;

    private int courseId;

    private int classId;

    private int regularScore;

    private int midScore;

    private int experimentalScore;

    private int finalScore;

    private int comprehensiveScore;

    private String scoreGenerationTime;

    public Score(int studentId, int courseId, int classId) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.classId = classId;
        generate();
    }

    private void generate() {
        Random random = new Random();

        // randomly generate score between 60-100
        regularScore = random.nextInt(41) + 60;
        midScore = random.nextInt(41) + 60;
        experimentalScore = random.nextInt(41) + 60;
        finalScore = random.nextInt(41) + 60;
        comprehensiveScore = (regularScore + midScore + experimentalScore + finalScore) / 4;

        // record score generated time
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        scoreGenerationTime = currentTime.format(formatter);
    }

    public String toString() {
        return "Score{" +
                "studentId=" + studentId +
                ", courseId=" + courseId +
                ", classId=" + classId +
                ", regularScore=" + regularScore +
                ", midScore=" + midScore +
                ", experimentalScore=" + experimentalScore +
                ", finalScore=" + finalScore +
                ", comprehensiveScore=" + comprehensiveScore +
                ", ScoreGenerationTime='" + scoreGenerationTime + '\'' +
                '}';
    }
}
