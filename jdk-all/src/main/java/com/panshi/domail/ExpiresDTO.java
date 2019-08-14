package com.panshi.domail;

import lombok.Data;

import java.util.Date;

/**
*@description: 预约对象
*@author: 邓俊豪
*@create: 2019/08/14
*/
@Data
public class ExpiresDTO {
    private int id;
    private int userId;
    private int bikeId;
    private String expires;
    private Date cTime;
    private Date upTime;
}
