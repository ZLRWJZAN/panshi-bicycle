package com.panshi.bikeservice.domain;

import lombok.Data;

import java.util.Date;

/**
 * @description:位置表
 * @author：ZLRWJSAN
 * @date 2019/8/15 10:57
 */
@Data
public class LocationDo {
    private Integer id;
    private String location;
    private Date cTime;
    private Date upTime;
}
