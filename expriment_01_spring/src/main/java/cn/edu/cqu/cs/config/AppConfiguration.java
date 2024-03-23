package cn.edu.cqu.cs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@ComponentScan(basePackages={"cn.edu.cqu.cs"})
public class AppConfiguration {
    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(
                "jdbc:mysql://localhost:3306/javaee1",
                "root",
                "atri") ;
    }
}
