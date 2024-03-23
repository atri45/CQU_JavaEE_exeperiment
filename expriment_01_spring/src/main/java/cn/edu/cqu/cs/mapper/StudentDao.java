package cn.edu.cqu.cs.mapper;

import cn.edu.cqu.cs.entity.Student;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDao extends BasicDao{

    public void create() {
        String sql = "create table if not exists student(studentId int, name varchar(10), sex varchar(10), grade int, classId varchar(10), courseId varchar(10))";
        try {
            Statement statement = connection.createStatement();
            statement.execute("drop table if exists student");
            statement.execute(sql);

        } catch (SQLException e) {
            // 异常处理
            System.out.println("Failed to execute sql: " + sql);
        }
    }

    public void insert(Student student) {
        String sql = "INSERT INTO student VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, student.getStudentId());
            statement.setString(2, student.getName());
            statement.setString(3, student.getSex());
            statement.setInt(4, student.getGrade());
            statement.setString(5, student.getClassId().toString());
            statement.setString(6, student.getCourseId().toString());
            statement.executeUpdate();

        } catch (SQLException e) {
            // 异常处理
            System.out.println("Failed to execute sql: " + sql);
        }
    }

    public void update(Student student) {
        String sql = "UPDATE student SET name=?, grade=?, sex=? WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setInt(2, student.getGrade());
            statement.setString(3, student.getSex());
            statement.setInt(4, student.getStudentId());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Failed to execute sql: " + sql);
        }
    }

    public void delete(long id) {
        String sql = "DELETE FROM student WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Failed to execute sql: " + sql);
        }
    }

    public Student query(long id) {
        String sql = "SELECT * FROM student WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int studentId = resultSet.getInt("studentId");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                int grade = resultSet.getInt("grade");
                List<String> classIdStrs = List.of(resultSet.getString("classId").split(","));
                List<Integer> classId = new ArrayList<>();
                for (String classIdStr : classIdStrs) {
                    classId.add(Integer.valueOf(classIdStr));
                }
                List<String> courseIdStrs = List.of(resultSet.getString("courseId").split(","));
                List<Integer> courseId = new ArrayList<>();
                for (String courseIdStr : courseIdStrs) {
                    courseId.add(Integer.valueOf(courseIdStr));
                }

                return new Student(studentId, name, sex, grade, classId, courseId);
            }
        } catch (SQLException e) {
            System.out.println("Failed to execute sql: " + sql);
        }
        return null;
    }

    public List<Student> queryAll() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int studentId = resultSet.getInt("studentId");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                int grade = resultSet.getInt("grade");
                List<String> classIdStrs = List.of(resultSet.getString("classId").split(","));
                List<Integer> classId = new ArrayList<>();
                for (String classIdStr : classIdStrs) {
                    classId.add(Integer.valueOf(classIdStr));
                }
                List<String> courseIdStrs = List.of(resultSet.getString("courseId").split(","));
                List<Integer> courseId = new ArrayList<>();
                for (String courseIdStr : courseIdStrs) {
                    courseId.add(Integer.valueOf(courseIdStr));
                }

                students.add(new Student(studentId, name, sex, grade, classId, courseId));
            }
        } catch (SQLException e) {
            System.out.println("Failed to execute sql: " + sql);
        }
        return students;
    }

}
