package cn.edu.cqu.cs.mapper;

import cn.edu.cqu.cs.entity.Score;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ScoreDao extends BasicDao{

    public void create() {
        String sql = "create table if not exists score(studentId int, courseId int, classId int, regularScore int, midScore int, experimentalScore int, finalScore int, comprehensiveScore int, scoreGenerationTime varchar(255))";
        try {
            Statement statement = connection.createStatement();
            statement.execute("drop table if exists score");
            statement.execute(sql);

        } catch (SQLException e) {
            // Exception handling
            System.out.println("Failed to execute sql: " + sql);
        }
    }

    public void insert(Score score) {
        String sql = "INSERT INTO score VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, score.getStudentId());
            statement.setInt(2, score.getCourseId());
            statement.setInt(3, score.getClassId());
            statement.setInt(4, score.getRegularScore());
            statement.setInt(5, score.getMidScore());
            statement.setInt(6, score.getExperimentalScore());
            statement.setInt(7, score.getFinalScore());
            statement.setInt(8, score.getComprehensiveScore());
            statement.setString(9, score.getScoreGenerationTime());
            statement.executeUpdate();

        } catch (SQLException e) {
            // Exception handling
            System.out.println("Failed to execute sql: " + sql);
        }
    }

    public void update(Score score) {
        String sql = "UPDATE score SET regularScore=?, midScore=?, experimentalScore=?, finalScore=?, comprehensiveScore=?, scoreGenerationTime=? WHERE studentId=? AND courseId=? AND classId=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, score.getRegularScore());
            statement.setInt(2, score.getMidScore());
            statement.setInt(3, score.getExperimentalScore());
            statement.setInt(4, score.getFinalScore());
            statement.setInt(5, score.getComprehensiveScore());
            statement.setString(6, score.getScoreGenerationTime());
            statement.setInt(7, score.getStudentId());
            statement.setInt(8, score.getCourseId());
            statement.setInt(9, score.getClassId());
            statement.executeUpdate();

        } catch (SQLException e) {
            // Exception handling
            System.out.println("Failed to execute sql: " + sql);
        }
    }

    public void delete(long id) {
        String sql = "DELETE FROM score WHERE studentId=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            // Exception handling
            System.out.println("Failed to execute sql: " + sql);
        }
    }

    public Score query(long id) {
        String sql = "SELECT * FROM score WHERE studentId=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            // Execute SQL query
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int studentId = resultSet.getInt("studentId");
                int courseId = resultSet.getInt("courseId");
                int classId = resultSet.getInt("classId");
                int regularScore = resultSet.getInt("regularScore");
                int midScore = resultSet.getInt("midScore");
                int experimentalScore = resultSet.getInt("experimentalScore");
                int finalScore = resultSet.getInt("finalScore");
                int comprehensiveScore = resultSet.getInt("comprehensiveScore");
                String scoreGenerationTime = resultSet.getString("scoreGenerationTime");
                return new Score(studentId, courseId, classId, regularScore, midScore, experimentalScore, finalScore, comprehensiveScore, scoreGenerationTime);
            }
        } catch (SQLException e) {
            // Exception handling
            System.out.println("Failed to execute sql: " + sql);
        }
        return null;
    }

    public List<Score> queryAll() {
        List<Score> scores = new ArrayList<>();
        String sql = "SELECT * FROM score";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            // Execute SQL query
            ResultSet resultSet = statement.executeQuery();

            // Extract scores from result set
            while (resultSet.next()) {
                int studentId = resultSet.getInt("studentId");
                int courseId = resultSet.getInt("courseId");
                int classId = resultSet.getInt("classId");
                int regularScore = resultSet.getInt("regularScore");
                int midScore = resultSet.getInt("midScore");
                int experimentalScore = resultSet.getInt("experimentalScore");
                int finalScore = resultSet.getInt("finalScore");
                int comprehensiveScore = resultSet.getInt("comprehensiveScore");
                String scoreGenerationTime = resultSet.getString("scoreGenerationTime");
                scores.add(new Score(studentId, courseId, classId, regularScore, midScore, experimentalScore, finalScore, comprehensiveScore, scoreGenerationTime));
            }
        } catch (SQLException e) {
            // Exception handling
            System.out.println("Failed to execute sql: " + sql);
        }
        return scores;
    }

}

