package com.panshi.domail;

public enum Message {

    VERIFY_SUCCEED(200,"登录成功");

    Message(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;

    private String msg;


    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
