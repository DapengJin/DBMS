/*
 * @Author: Jin X
 * @Date: 2020-02-19 12:51:43
 * @LastEditTime: 2020-02-19 13:35:03
 */

package com.dbms.project1.Repository;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class RedshiftConfig {
    

    @Bean(name="dsredshift")
    @Qualifier("dsredshift")
    public DataSource dataSource() {
        DataSourceBuilder dsbuilder = DataSourceBuilder.create();
        dsbuilder.driverClassName("com.amazon.redshift.jdbc.Driver")
                .url("jdbc:redshift://redshift-cluster-1.ctjgblwcy5ws.us-east-2.redshift.amazonaws.com:5439/dev")
                .username("awsuser").password("Db12345678");
        return dsbuilder.build();
    }
    

    @Bean("jdbcredshift")
    public JdbcTemplate jdbcTemplate(DataSource dsredshift) {
        return new JdbcTemplate(dsredshift);
    }
}