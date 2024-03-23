package cn.edu.cqu.cs.mapper;

import cn.edu.cqu.cs.config.AppConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class BasicDao {
    static ApplicationContext applicationContext;
    static DataSource dataSource;
    static Connection connection;

    // initialize
    static {
        try {
            applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
            dataSource = (DataSource) applicationContext.getBean("dataSource");
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
