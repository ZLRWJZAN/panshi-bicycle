package com.panshi.domail;

import lombok.Data;

/**
*@description: 返回类型2
*@author: 邓俊豪
*@create: 2019/08/14
*/
@Data
public class ReturnsDTO extends ReturnDTO{

    boolean state;

    int code;

    String message;
}
