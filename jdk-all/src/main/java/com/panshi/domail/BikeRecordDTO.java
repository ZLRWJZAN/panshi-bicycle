package com.panshi.domail;

import lombok.Data;

import java.util.Date;

/**
*@description: 骑车记录类
*@author: 邓俊豪
*@create: 2019/08/14
*/
@Data
public class BikeRecordDTO {
    private int id;
    private int userId;
    private int bikeId;
    private int beginId;
    private int endId;
    private Date beginTime;
    private Date endTime;
    private Float runKm;
    private Float runCost;
    private Date upTime;

    public BikeRecordDTO() {
    }

    public BikeRecordDTO(int userId, int bikeId, int beginId) {
        this.userId = userId;
        this.bikeId = bikeId;
        this.beginId = beginId;
    }
}
