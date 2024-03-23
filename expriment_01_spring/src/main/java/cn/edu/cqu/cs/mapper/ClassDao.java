package cn.edu.cqu.cs.mapper;

import cn.edu.cqu.cs.entity.Class;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClassDao extends BasicDao{
    
    public void create() {
        String sql = "create table if not exists class(classId int, courseId int, studentNum int, openSemester int)";
        try {
            Statement statement = connection.createStatement();
            statement.execute("drop table if exists class");
            statement.execute(sql);

        } catch (SQLException e) {
            // 异常处理
            System.out.println("Failed to execute sql: " + sql);
        }
    }
    
    public void insert(Class classObj) {
        String sql = "INSERT INTO class VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, classObj.getClassId());
            statement.setInt(2, classObj.getCourseId());
            statement.setInt(3, classObj.getStudentNum());
            statement.setInt(4, classObj.getOpenSemester());
            statement.executeUpdate();

        } catch (SQLException e) {
            // 异常处理
            System.out.println("Failed to execute sql: " + sql);
        }
    }

    public void update(Class classObj) {
        String sql = "UPDATE class SET courseId=?, studentNum=?, openSemester=? WHERE classId=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, classObj.getCourseId());
            statement.setInt(2, classObj.getStudentNum());
            statement.setInt(3, classObj.getOpenSemester());
            statement.setInt(4, classObj.getClassId());

            int affectedRows = statement.executeUpdate();

//            if (affectedRows > 0) {
//                System.out.println("更新成功!");
//            }
        } catch (SQLException e) {
            System.out.println("Failed to execute sql: " + sql);
        }
    }
    
    public void delete(long id) {
        String sql = "DELETE FROM class WHERE classId=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            int affectedRows = statement.executeUpdate();

//            if (affectedRows > 0) {
//                System.out.println("删除成功!");
//            }
        } catch (SQLException e) {
            System.out.println("Failed to execute sql: " + sql);
        }
    }
    
    public Class query(long id) {
        String sql = "SELECT * FROM class WHERE classId=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int classId = resultSet.getInt("classId");
                int courseId = resultSet.getInt("courseId");
                int studentNum = resultSet.getInt("studentNum");
                int openSemester = resultSet.getInt("openSemester");

                return new Class(classId, courseId, studentNum, openSemester);
            }
        } catch (SQLException e) {
            System.out.println("Failed to execute sql: " + sql);
        }
        return null;
    }
    
    public List<Class> queryAll() {
        List<Class> classes = new ArrayList<>();
        String sql = "SELECT * FROM class";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int classId = resultSet.getInt("classId");
                int courseId = resultSet.getInt("courseId");
                int studentNum = resultSet.getInt("studentNum");
                int openSemester = resultSet.getInt("openSemester");

                classes.add(new Class(classId, courseId, studentNum, openSemester));
            }
        } catch (SQLException e) {
            System.out.println("Failed to execute sql: " + sql);
        }
        return classes;
    }

}
