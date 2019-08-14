package com.panshi.domail;

import lombok.Data;

/**
*@description: 返回消息类
*@author: 邓俊豪
*@create: 2019/08/14
*/
@Data
public class ReturnDTO {
    int code;
    boolean state;
    String message;
    String type;
}
