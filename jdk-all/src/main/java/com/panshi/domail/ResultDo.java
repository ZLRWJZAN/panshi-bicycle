package com.panshi.domail;

import lombok.Data;

import java.io.Serializable;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/24 22:58
 * @author Administrator
 */

@Data
public class ResultDo<T> implements Serializable {
    private T data;
    private Integer code;
    private String message;
}
