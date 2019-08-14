package com.panshi.domail;

import lombok.Data;

import java.util.Date;

/**
 * @author：ZLRWJSAN
 * @date 2019/8/14 15:15
 */
@Data
public class RideBikeDTO extends ReturnDTO {
    Integer code;
    boolean state;
    String message;
    String type;
    Integer vehicleid;
    Date vefubtime;
    String region;
}
