package com.panshi.bikeservice.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description:账户表
 * @author：ZLRWJSAN
 * @date 2019/8/15 19:42
 */
@Data
public class AccountDo implements Serializable {
    Integer id;
    Integer userId;
    BigDecimal balance;
    BigDecimal deposit;
    String noPassword;
    String payPassword;
    Date cTime;
    Date upTime;
}
