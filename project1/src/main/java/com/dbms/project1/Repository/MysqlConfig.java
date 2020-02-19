/*
 * @Author: Jin X
 * @Date: 2020-02-18 16:34:08
 * @LastEditTime: 2020-02-19 12:55:30
 */

package com.dbms.project1.Repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class MysqlConfig {
    @Bean(name = "dsmysql")
    @Qualifier("dsmysql")
    public DataSource datasource() {
        DataSourceBuilder dsbuilder = DataSourceBuilder.create();
        dsbuilder.driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://instacartdb.c8ojtshzefs1.us-east-2.rds.amazonaws.com:3306/instacart")
                .username("admin")
                .password("12345678");
                

                
        return dsbuilder.build();
    }

    @Bean("jdbcmysql")
    public JdbcTemplate jdbcTemplate(DataSource dsmysql) {
        return new JdbcTemplate(dsmysql);
    }
}