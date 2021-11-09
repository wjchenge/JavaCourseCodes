package com.wjchenge.homework9;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author wj
 * @Date 2021/11/8 20:29
 */
@Configuration
public class RoutingConfiguration {

    @Bean
    @ConfigurationProperties("master.datasource")
    public DataSourceProperties masterDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("slave.datasource")
    public DataSourceProperties slaveDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource dataSource() {
        Map<Object, Object> targetDataSources = new HashMap<>();
        DataSource masterDatasource = masterDatasource();
        DataSource slaveDatasource = slaveDatasource();
        targetDataSources.put(com.wjchenge.homework9.DataSource.MASTER, masterDatasource);
        targetDataSources.put(com.wjchenge.homework9.DataSource.SLAVE, slaveDatasource);

        MyRoutingDataSource myRoutingDataSource = new MyRoutingDataSource();
        myRoutingDataSource.setTargetDataSources(targetDataSources);
        myRoutingDataSource.setDefaultTargetDataSource(masterDatasource());
        return myRoutingDataSource;
    }


    private DataSource masterDatasource() {
        DataSourceProperties dataSourceProperties = masterDataSourceProperties();
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    private DataSource slaveDatasource() {
        DataSourceProperties dataSourceProperties = slaveDataSourceProperties();
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }


}
