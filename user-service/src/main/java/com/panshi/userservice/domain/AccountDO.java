package com.panshi.userservice.domain;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description: 账户属性DO
 * @author: 蓝文娜
 * @create: 2019/08/14
 */
@Data
public class AccountDO {
    /**
     * 账户id
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户余额
     */
    private BigDecimal balance;
    /**
     * 押金
     */
    private BigDecimal deposit;
    /**
     * 是否开通免密（0：否 1：是）
     */
    private String noPassword;
    /**
     * 支付密码
     */
    private String payPassword;
    /**
     * 创建时间
     */
    private Date cTime;
    /**
     * 修改时间
     */
    private Date upTime;
}
