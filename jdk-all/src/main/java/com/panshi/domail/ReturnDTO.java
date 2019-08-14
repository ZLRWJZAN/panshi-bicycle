package com.panshi.domail;

import lombok.Data;

import java.io.Serializable;

/**
*@description: 返回消息类
*@author: 邓俊豪
*@create: 2019/08/14
*/
@Data
public class ReturnDTO implements Serializable {
    Integer code;
    boolean state;
    String message;
    String data;
    String type;
}
