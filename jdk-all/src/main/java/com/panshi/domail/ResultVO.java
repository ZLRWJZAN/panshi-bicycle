package com.panshi.domail;

import lombok.Data;

@Data
public class ResultVO<T> {

    private Integer errorCode;

    private String msg;

    private T data;


    public ResultVO(int errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public ResultVO() {
    }
}
