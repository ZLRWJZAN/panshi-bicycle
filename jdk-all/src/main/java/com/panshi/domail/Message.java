package com.panshi.domail;

public enum Message {

    VERIFY_SUCCEED(200,"登录成功"),

    PHONE_EMPTY(301,"手机号不存在"),
    VERIFY_CODE_ERROR(302,"验证码错误"),
    ACCOUNT_PASSWORD_ERROR(501,"账号或密码输入错误"),
    ACCOUNT_EMPTY(502,"账号不存在")

    ;

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
