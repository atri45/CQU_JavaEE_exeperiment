package cn.edu.cqu.cs.mapper;


import cn.edu.cqu.cs.entity.Course;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseDao extends BasicDao{

    public void create() {
        String sql = "create table if not exists course(courseId int, name varchar(255))";
        try {
            Statement statement = connection.createStatement();
            statement.execute("drop table if exists course");
            statement.execute(sql);

        } catch (SQLException e) {
            // 异常处理
            System.out.println("Failed to execute sql: " + sql);
        }
    }

    public void insert(Course course) {
        String sql = "INSERT INTO course VALUES (?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, course.getCourseId());
            statement.setString(2, course.getName());
            statement.executeUpdate();

        } catch (SQLException e) {
            // 异常处理
            System.out.println("Failed to execute sql: " + sql);
        }
    }

    public void update(Course course) {
        String sql = "UPDATE course SET name=? WHERE courseId=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, course.getName());
            statement.setInt(2, course.getCourseId());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Failed to execute sql: " + sql);
        }
    }

    public void delete(long id) {
        String sql = "DELETE FROM course WHERE courseId=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Failed to execute sql: " + sql);
        }
    }

    public Course query(long id) {
        String sql = "SELECT * FROM course WHERE courseId=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int courseId = resultSet.getInt("courseId");
                String name = resultSet.getString("name");

                return new Course(courseId, name);
            }
        } catch (SQLException e) {
            System.out.println("Failed to execute sql: " + sql);
        }
        return null;
    }

    public List<Course> queryAll() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM course";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int courseId = resultSet.getInt("courseId");
                String name = resultSet.getString("name");

                courses.add(new Course(courseId, name));
            }
        } catch (SQLException e) {
            System.out.println("Failed to execute sql: " + sql);
        }
        return courses;
    }
}
