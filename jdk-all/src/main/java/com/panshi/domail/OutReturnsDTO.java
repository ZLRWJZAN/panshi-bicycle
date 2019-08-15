package com.panshi.domail;

import lombok.Data;

/**
*@description: 返回类型2
*@author: 邓俊豪
*@create: 2019/08/14
*/
@Data
public class OutReturnsDTO extends ReturnDTO{

    boolean state;

    int code;

    String message;

    String billingway;

    public OutReturnsDTO(int i, boolean b, String message) {
        super(i, b, message);
    }
    public OutReturnsDTO(){}
}
