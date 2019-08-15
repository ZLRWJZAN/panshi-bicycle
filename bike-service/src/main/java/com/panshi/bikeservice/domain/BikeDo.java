package com.panshi.bikeservice.domain;

import lombok.Data;

import java.util.Date;

/**
 * @description:单车表
 * @author：ZLRWJSAN
 * @date 2019/8/15 10:46
 */
@Data
public class BikeDo {
    private Integer id;
    private Integer locationId;
    private Integer bikeNum;
    private String bikeState;
    private Date cTime;
    private Date upTime;
}
