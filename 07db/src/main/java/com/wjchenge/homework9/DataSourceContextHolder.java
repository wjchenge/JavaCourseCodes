package com.wjchenge.homework9;

/**
 * @Author wj
 * @Date 2021/11/9 0:15
 */
public class DataSourceContextHolder {

    private static final ThreadLocal<DataSource> CONTEXT = new ThreadLocal<>();

    public static void set(DataSource dataSource) {
        CONTEXT.set(dataSource);
    }

    public static DataSource getDataSource() {
        return CONTEXT.get();
    }

    public static void clear() {
        CONTEXT.remove();
    }
}
