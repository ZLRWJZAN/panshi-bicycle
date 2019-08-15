package com.panshi.bikeservice.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description:配置DO
 * @author：ZLRWJSAN
 * @date 2019/8/14 17:25
 */
@Data
public class ConfigDo implements Serializable {
    private Integer id;
    private BigDecimal deposit;
    private BigDecimal money;
    private BigDecimal flagFall;
    private Date cTime;
    private Date upTime;
    private String billingway;
}
