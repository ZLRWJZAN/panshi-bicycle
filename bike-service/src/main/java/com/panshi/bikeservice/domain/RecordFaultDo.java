package com.panshi.bikeservice.domain;

import lombok.Data;

import java.util.Date;

/**
*@description: 故障记录表
*@author: 邓俊豪
*@create: 2019/08/16
*/
@Data
public class RecordFaultDo {
    Integer id;
    Integer userId;
    Integer bickId;
    Date cTime;
    Date disTime;
    String faultType;
    String remark;
    Date upTime;
}
