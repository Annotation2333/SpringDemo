package com.example.spring.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class LiquibaseConfig {

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        // Use liquibase.integration.spring.SpringLiquibase if you don't want Liquibase to start asynchronously
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        //指定changelog的位置，这里使用的一个master文件引用其他文件的方式
        liquibase.setChangeLog("classpath:liquibase/master.xml");
        liquibase.setShouldRun(true);
        return liquibase;
    }

}

