package org.zerock.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = {"org.zerock.sample"})
@MapperScan(basePackages = {"org.zerock.mapper"})
public class RootConfig {
    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        //hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver"); 
        //hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:49161:xe");
        hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy"); // log4jdbc.log42j 설정후 
        hikariConfig.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@localhost:49161:xe"); // log4jdbc.log42j 설정후
        
        hikariConfig.setUsername("system");
        hikariConfig.setPassword("oracle");

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        return dataSource;
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource());
        return (SqlSessionFactory) sqlSessionFactory.getObject();
    }
}

