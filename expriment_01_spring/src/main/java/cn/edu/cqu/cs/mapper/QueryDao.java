package cn.edu.cqu.cs.mapper;

import cn.edu.cqu.cs.entity.QueryResult;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QueryDao extends BasicDao{

    public List<QueryResult> queryStudents(int id) {
        String sql = "";
        PreparedStatement statement;
        try {
            // get query sql
            if (id >= 0) {
                sql = "SELECT * FROM student join score on student.studentId=? and student.studentId=score.studentId join course on score.courseId = course.courseId";
                statement = connection.prepareStatement(sql);
                statement.setLong(1, id);
            }
            else {
                sql = "SELECT * FROM student join score on student.studentId=score.studentId join course on score.courseId = course.courseId";
                statement = connection.prepareStatement(sql);
            }

            // Execute SQL query
            ResultSet resultSet = statement.executeQuery();
            List<QueryResult> queryResults = new ArrayList<>();

            while (resultSet.next()) {
                int studentId = resultSet.getInt("studentId");
                String studentName = resultSet.getString("name");
                String courseName = resultSet.getString("course.name");
                int regularScore = resultSet.getInt("regularScore");
                int midScore = resultSet.getInt("midScore");
                int experimentalScore = resultSet.getInt("experimentalScore");
                int finalScore = resultSet.getInt("finalScore");
                int comprehensiveScore = resultSet.getInt("comprehensiveScore");
                QueryResult queryResult = new QueryResult(regularScore, midScore, experimentalScore, finalScore, comprehensiveScore);
                queryResult.setStudentId(studentId);
                queryResult.setStudentName(studentName);
                queryResult.setCourseName(courseName);
                queryResults.add(queryResult);
            }
            return queryResults;
        } catch (SQLException e) {
            // Exception handling
            System.out.println("Failed to execute sql: " + sql);
        }
        return null;
    }

    public List<QueryResult> queryCourses(int id, int order) {
        String sql = "";
        PreparedStatement statement;
        try {
            // get query sql
            if (id >= 0) {
                if (order == 1) {
                    sql = "SELECT * FROM course join score on course.courseId=? and course.courseId=score.courseId join student on score.studentId = student.studentId order by student.studentId";
                }
                else {
                    sql = "SELECT * FROM course join score on course.courseId=? and course.courseId=score.courseId join student on score.studentId = student.studentId order by comprehensiveScore DESC";
                }
                statement = connection.prepareStatement(sql);
                statement.setLong(1, id);
            }
            else {
                if (order == 1) {
                    sql = "SELECT * FROM course join score on course.courseId=score.courseId join student on score.studentId = student.studentId order by course.courseId, student.studentId";
                }
                else {
                    sql = "SELECT * FROM course join score on course.courseId=score.courseId join student on score.studentId = student.studentId order by course.courseId, comprehensiveScore DESC";
                }
                statement = connection.prepareStatement(sql);
            }

            // Execute SQL query
            ResultSet resultSet = statement.executeQuery();
            List<QueryResult> queryResults = new ArrayList<>();

            while (resultSet.next()) {
                int courseId = resultSet.getInt("courseId");
                String courseName = resultSet.getString("name");
                String studentName = resultSet.getString("student.name");
                int regularScore = resultSet.getInt("regularScore");
                int midScore = resultSet.getInt("midScore");
                int experimentalScore = resultSet.getInt("experimentalScore");
                int finalScore = resultSet.getInt("finalScore");
                int comprehensiveScore = resultSet.getInt("comprehensiveScore");
                QueryResult queryResult = new QueryResult(regularScore, midScore, experimentalScore, finalScore, comprehensiveScore);
                queryResult.setCourseId(courseId);
                queryResult.setCourseName(courseName);
                queryResult.setStudentName(studentName);
                queryResults.add(queryResult);
            }
            return queryResults;
        } catch (SQLException e) {
            // Exception handling
            System.out.println("Failed to execute sql: " + sql);
        }
        return null;
    }

    public List<QueryResult> queryClasses(int id, int order) {
        String sql = "";
        PreparedStatement statement;
        try {
            // get query sql
            if (id >= 0) {
                if (order == 1) {
                    sql = "SELECT * FROM class join score on class.classId=? and class.classId=score.classId join course on score.courseId = course.courseId join student on score.studentId = student.studentId order by student.studentId";
                }
                else {
                    sql = "SELECT * FROM class join score on class.classId=? and class.classId=score.classId join course on score.courseId = course.courseId join student on score.studentId = student.studentId order by comprehensiveScore DESC";
                }
                statement = connection.prepareStatement(sql);
                statement.setLong(1, id);
            }
            else {
                if (order == 1) {
                    sql = "SELECT * FROM class join score on class.classId=score.classId join course on score.courseId = course.courseId join student on score.studentId = student.studentId order by class.classId, student.studentId";
                }
                else {
                    sql = "SELECT * FROM class join score on class.classId=score.classId join course on score.courseId = course.courseId join student on score.studentId = student.studentId order by class.classId, comprehensiveScore DESC";
                }
                statement = connection.prepareStatement(sql);
            }

            // Execute SQL query
            ResultSet resultSet = statement.executeQuery();
            List<QueryResult> queryResults = new ArrayList<>();

            while (resultSet.next()) {
                int classId = resultSet.getInt("classId");
                String courseName = resultSet.getString("name");
                String studentName = resultSet.getString("student.name");
                int regularScore = resultSet.getInt("regularScore");
                int midScore = resultSet.getInt("midScore");
                int experimentalScore = resultSet.getInt("experimentalScore");
                int finalScore = resultSet.getInt("finalScore");
                int comprehensiveScore = resultSet.getInt("comprehensiveScore");
                QueryResult queryResult = new QueryResult(regularScore, midScore, experimentalScore, finalScore, comprehensiveScore);
                queryResult.setClassId(classId);
                queryResult.setCourseName(courseName);
                queryResult.setStudentName(studentName);
                queryResults.add(queryResult);
            }
            return queryResults;
        } catch (SQLException e) {
            // Exception handling
            System.out.println("Failed to execute sql: " + sql);
        }
        return null;
    }
}
