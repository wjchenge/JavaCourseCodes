package com.wjchenge.customerstarter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author wj
 * @Date 2021/10/25 10:21
 */
@ConfigurationProperties("customer")
@Data
public class CustomerProperties {

    private int id;

    private String name;
}
