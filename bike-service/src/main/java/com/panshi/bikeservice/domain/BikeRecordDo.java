package com.panshi.bikeservice.domain;

import lombok.Data;

import java.util.Date;

/**
 * @description:骑行记录DO
 * @author：ZLRWJSAN
 * @date 2019/8/15 9:49
 */
@Data
public class BikeRecordDo {
    private Integer id;
    private Integer userId;
    private Integer bikeId;
    private Integer beginId;
    private Integer endId;
    private Date beginTime;
    private Date endTime;
    private Float runKm;
    private Float runCost;
    private Date upTime;
    public BikeRecordDo() {
    }

    public BikeRecordDo(int userId, int bikeId, int beginId) {
        this.userId = userId;
        this.bikeId = bikeId;
        this.beginId = beginId;
    }
}
