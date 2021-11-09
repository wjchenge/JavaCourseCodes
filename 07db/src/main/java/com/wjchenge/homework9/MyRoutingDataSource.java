package com.wjchenge.homework9;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author wj
 * @Date 2021/11/8 20:17
 */
public class MyRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSource();
    }
}
