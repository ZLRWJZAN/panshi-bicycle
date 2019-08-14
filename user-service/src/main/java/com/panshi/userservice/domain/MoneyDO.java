package com.panshi.userservice.domain;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description: 金额流水属性DO
 * @author: 蓝文娜
 * @create: 2019/08/14
 */
@Data
public class MoneyDO {
    /**
     * 金额流水id
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 支付类型id
     */
    private Integer paymentId;
    /**
     * 金额
     */
    private BigDecimal money;
    /**
     * 收支类型（0：收入 1：支出）
     */
    private String inOut;
    /**
     * 创建时间
     */
    private Date cTime;
    /**
     * 修改时间
     */
    private Date upTime;
}
