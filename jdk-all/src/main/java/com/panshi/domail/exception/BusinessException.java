package com.panshi.domail.exception;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException{

 private Integer code;

 private String message;

    public BusinessException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
