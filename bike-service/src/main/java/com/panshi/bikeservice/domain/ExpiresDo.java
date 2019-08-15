package com.panshi.bikeservice.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
*@description: 输出预约类
*@author: 邓俊豪
*@create: 2019/08/15
*/
@Data
public class ExpiresDo implements Serializable {
    private int id;
    private int userId;
    private int bikeId;
    private String expires;
    private Date cTime;
    private Date upTime;
}
