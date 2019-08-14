package com.panshi.domail;

import lombok.Data;

import java.util.Date;

/**
*@description: 单车类
*@author: 邓俊豪
*@create: 2019/08/14
*/
@Data
public class BikeDTO {
    int id;
    int locationId;
    int bikeNum;
    String bikeState;
    Date cTime;
    Date upTime;
}
