package com.panshi.bikeservice.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:故障记录表
 * @author：ZLRWJSAN
 * @date 2019/8/16 17:07
 */
@Data
public class FaultRecordDo implements Serializable {
    private Integer id;
    private Integer userId;
    private Integer bickId;
    private Date cTime;
    private Date disTime;
    private String faultType;
    private String remark;
    private Date upTime;
    private String state;
    private BikeDo bikeDo;
}
