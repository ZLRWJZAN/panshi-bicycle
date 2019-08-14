package com.panshi.domail;

import lombok.Data;

/**
 * @author：ZLRWJSAN
 * @date 2019/8/14 15:26
 */
@Data
public class RegionDTO extends ReturnDTO {
    Integer code;
    boolean state;
    String message;
    String region;
}
