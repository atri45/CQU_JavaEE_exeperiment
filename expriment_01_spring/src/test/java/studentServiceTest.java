import cn.edu.cqu.cs.config.AppConfiguration;
import cn.edu.cqu.cs.entity.Student;
import cn.edu.cqu.cs.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.Assert.*;

public class studentServiceTest {

    private static StudentService studentService = new StudentService();
    private static ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfiguration.class);
    private static DataSource d = (DataSource) ac.getBean("dataSource");
    private static Connection c;

    private static Statement s;

    static {
        try {
            // get connection
            c = d.getConnection();
            s = c.createStatement();

            // create table
            s.execute("drop table if exists student");
            s.execute("create table student (id int, name varchar(20), age int, sex varchar(10))");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void insertTest() throws SQLException {
        //insert
        studentService.insert(new Student(20214578, "zzj", "male", 2021));

        // Query=
        Student queriedStudent = studentService.query(20214578);

        // Check=
        assertNotNull(queriedStudent);
    }

    @Test
    public void testUpdate() throws SQLException {
        // insert
        studentService.insert(new Student(20214578, "zzj", "male", 2021));

        // Update
        studentService.update(new Student(20214578, "UpdatedName", "female", 2021));

        // Query
        Student updatedStudent = studentService.query(20214578);

        // Check
        assertEquals("UpdatedName", updatedStudent.getName());
        assertEquals(25, updatedStudent.getGrade());
        assertEquals("female", updatedStudent.getSex());
    }

    @Test
    public void testDelete() throws SQLException {
        // insert
        studentService.insert(new Student(20214578, "zzj", "male", 2021));

        // Delete
        studentService.delete(20214578);

        // Query
        Student queriedStudent = studentService.query(20214578);

        // Check
        assertNull(queriedStudent);
    }

    @Test
    public void testQuery() throws SQLException {
        // reCreate table
        s.execute("drop table if exists student");
        s.execute("create table student (id int, name varchar(20), age int, sex varchar(10))");

        // insert
        Student studentToQuery = new Student(20214578, "NameToQuery", "female", 2021);
        studentService.insert(studentToQuery);

        // Query
        Student queriedStudent = studentService.query(studentToQuery.getStudentId());

        // Check
        assertNotNull(queriedStudent);
        assertEquals(studentToQuery.getName(), queriedStudent.getName());
        assertEquals(studentToQuery.getGrade(), queriedStudent.getGrade());
        assertEquals(studentToQuery.getSex(), queriedStudent.getSex());
    }

    @Test
    public void testQueryAll() throws SQLException {
        // reCreate table
        s.execute("drop table if exists student");
        s.execute("create table student (id int, name varchar(20), age int, sex varchar(10))");

        // insert
        studentService.insert(new Student(20214578, "zzj", "male", 2021));
        studentService.insert(new Student(20214578, "zzj", "male", 2021));

        // Query
        List<Student> students = studentService.queryAll();

        // Check
        assertNotNull(students);
        assertEquals(2, students.size());
    }

}
