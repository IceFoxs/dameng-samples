package io.icefox.dmdemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.test-while-idle}")
    private Boolean testWhileIdle;

    @Value("${spring.datasource.validation-query}")
    private String validationQuery;
    @Value("${datasource.type}")
    private String type;
    @Value("${spring.datasource.maximum-pool-size}")
    private int maximumPoolSize;
    @Value("${spring.datasource.minimum-idle}")
    private int minimumIdle;

    private final static String Druid = "Druid";
    private final static String HikariCP = "HikariCP";

    @Bean
    DataSource dataSource() {
        if (Druid.equalsIgnoreCase(type)) {
            DruidDataSource druidDataSource = new DruidDataSource();
            druidDataSource.setUrl(url);
            druidDataSource.setUsername(username);
            druidDataSource.setPassword(password);
            druidDataSource.setDriverClassName(driverClassName);
            druidDataSource.setTestWhileIdle(testWhileIdle);
            druidDataSource.setValidationQuery(validationQuery);
            druidDataSource.setMaxActive(maximumPoolSize);
            druidDataSource.setMinIdle(minimumIdle);
            return druidDataSource;
        } else {
            HikariDataSource hikariDataSource = new HikariDataSource();
            hikariDataSource.setJdbcUrl(url);
            hikariDataSource.setUsername(username);
            hikariDataSource.setPassword(password);
            hikariDataSource.setDriverClassName(driverClassName);
            hikariDataSource.setMaximumPoolSize(maximumPoolSize);
            hikariDataSource.setMinimumIdle(minimumIdle);
            return hikariDataSource;
        }
    }
}
