package com.wjchenge.lock.homework4;

/**
 * @Author wj
 * @Date 2021/12/6 21:14
 */
public interface StockService {

    void init(long size);

    long getAndDecrement();
}
