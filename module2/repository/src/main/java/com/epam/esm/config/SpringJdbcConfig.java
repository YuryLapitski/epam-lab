package com.epam.esm.config;

import com.epam.esm.entity.Tag;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
    private String dataBaseDriverClassName;
    @Value("${pool.size}")
    private int poolSize;

    @Bean
    public DataSource dataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(dataBaseUrl);
        hikariDataSource.setUsername(dataBaseUserName);
        hikariDataSource.setPassword(dataBasePassword);
        hikariDataSource.setDriverClassName(dataBaseDriverClassName);
        hikariDataSource.setMaximumPoolSize(poolSize);
        return hikariDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public RowMapper<Tag> tagRowMapper() {
        return new BeanPropertyRowMapper<>(Tag.class);
    }
}
