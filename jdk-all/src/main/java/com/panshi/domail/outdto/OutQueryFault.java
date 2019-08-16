package com.panshi.domail.outdto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:返回故障详细信息
 * @author：ZLRWJSAN
 * @date 2019/8/16 17:29
 */
@Data
public class OutQueryFault implements Serializable {
    private Integer id;
    private Date cTime;
    private Date disTime;
    private String faultType;
    private String remark;
    private String state;
    private Integer bikeNum;
}
