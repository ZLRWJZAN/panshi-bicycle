package com.panshi.bikeservice.domain;

import lombok.Data;

import java.util.Date;

/**
*@description: 
*@author: 邓俊豪
*@create: 2019/08/15
*/
@Data
public class BikeDO {
    Integer id;
    Integer locationId;
    Integer bikeNum;
    String bikeState;
    Date cTime;
    Date upTime;
}
