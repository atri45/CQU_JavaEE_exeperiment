package cn.edu.cqu.cs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryResult {

    private int studentId;

    private String studentName;

    private int regularScore;

    private int midScore;

    private int experimentalScore;

    private int finalScore;

    private int comprehensiveScore;

    private int courseId;

    private String courseName;

    private int classId;

    public QueryResult(int regularScore, int midScore, int experimentalScore, int finalScore, int comprehensiveScore) {
        this.regularScore = regularScore;
        this.midScore = midScore;
        this.experimentalScore = experimentalScore;
        this.finalScore = finalScore;
        this.comprehensiveScore = comprehensiveScore;
    }
}
