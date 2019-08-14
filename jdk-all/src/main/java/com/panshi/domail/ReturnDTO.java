package com.panshi.domail;

import lombok.Data;

/**
*@description: 返回消息类
*@author: 邓俊豪
*@create: 2019/08/14
*/
@Data
public class ReturnDTO<T> {
    int code;
    boolean state;
    String message;
    String type;
    T data;

    public ReturnDTO(int code, boolean state, String message, String type, T data) {
        this.code = code;
        this.state = state;
        this.message = message;
        this.type = type;
        this.data = data;
    }

    public ReturnDTO(int i, boolean b, String message) {
        this.code = code;
        this.state = state;
        this.message = message;
    }
}
