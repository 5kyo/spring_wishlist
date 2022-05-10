package com.example.demo.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

@Configuration
@Component
public class DataSourceConfig {

    @Value("${spring.datasource.url:empty}")
    private String dataSourceUrl;


    @Bean
    public DataSource dataSource() throws JsonProcessingException, KeyManagementException, NoSuchAlgorithmException {

        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(dataSourceUrl);
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("root");
        return dataSourceBuilder.build();
    }
}