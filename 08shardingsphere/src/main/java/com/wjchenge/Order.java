package com.wjchenge;

import lombok.Data;

import java.util.Date;

/**
 * @Author wj
 * @Date 2021/11/15 14:16
 */
@Data
public class Order {
    private Long id;
    private Long orderNo;
    private Long userId;
    private Long shippingId;
    private Integer totalPayment;
    private Integer realPayment;
    private Integer paymentType;
    private Integer postage;
    private Integer status;
    private Date paymentTime;
    private Date sendTime;
    private Date endTime;
    private Date createTime;
}
