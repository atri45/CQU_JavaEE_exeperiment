package cn.edu.cqu.cs.mapper;

import cn.edu.cqu.cs.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TeacherDao extends BasicDao{

    public void create() {
        String sql = "create table if not exists teacher(teacherId int, name varchar(255), classId int)";
        try {
            Statement statement = connection.createStatement();
            statement.execute("drop table if exists teacher");
            statement.execute(sql);

        } catch (SQLException e) {
            // 异常处理
            System.out.println("Failed to execute sql: " + sql);
        }
    }

    public void insert(Teacher teacher) {
        String sql = "INSERT INTO teacher VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, teacher.getTeacherId());
            statement.setString(2, teacher.getName());
            statement.setInt(3, teacher.getClassId());
            statement.executeUpdate();

        } catch (SQLException e) {
            // 异常处理
            System.out.println("Failed to execute sql: " + sql);
        }
    }

    public void update(Teacher teacher) {
        String sql = "UPDATE teacher SET name=?, classId=? WHERE teacherId=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, teacher.getName());
            statement.setInt(2, teacher.getClassId());
            statement.setInt(3, teacher.getTeacherId());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Failed to execute sql: " + sql);
        }
    }

    public void delete(long id) {
        String sql = "DELETE FROM teacher WHERE teacherId=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Failed to execute sql: " + sql);
        }
    }

    public Teacher query(long id) {
        String sql = "SELECT * FROM teacher WHERE teacherId=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int teacherId = resultSet.getInt("teacherId");
                String name = resultSet.getString("name");
                int classId = resultSet.getInt("classId");

                return new Teacher(teacherId, name, classId);
            }
        } catch (SQLException e) {
            System.out.println("Failed to execute sql: " + sql);
        }
        return null;
    }

    public List<Teacher> queryAll() {
        List<Teacher> teachers = new ArrayList<>();
        String sql = "SELECT * FROM teacher";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int teacherId = resultSet.getInt("teacherId");
                String name = resultSet.getString("name");
                int classId = resultSet.getInt("classId");

                teachers.add(new Teacher(teacherId, name, classId));
            }
        } catch (SQLException e) {
            System.out.println("Failed to execute sql: " + sql);
        }
        return teachers;
    }
}
