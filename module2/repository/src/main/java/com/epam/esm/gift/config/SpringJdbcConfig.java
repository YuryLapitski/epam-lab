package com.epam.esm.gift.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:database.properties")
public class SpringJdbcConfig {
    @Value("${url}")
    private String dataBaseUrl;
    @Value("${user}")
    private String dataBaseUserName;
    @Value("${password}")
    private String dataBasePassword;
    @Value("${driver}")
    private String driverClassName;
    @Value("${pool.size}")
    private int poolSize;

    @Bean
    public DataSource dataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(dataBaseUrl);
        hikariDataSource.setUsername(dataBaseUserName);
        hikariDataSource.setPassword(dataBasePassword);
        hikariDataSource.setDriverClassName(driverClassName);
        hikariDataSource.setMaximumPoolSize(poolSize);
        return hikariDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
