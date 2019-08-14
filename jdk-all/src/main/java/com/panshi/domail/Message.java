package com.panshi.domail;

public enum Message {

    VERIFY_SUCCEED(200,"登录成功"),
    VERIFY_REGISTER(200,"注册成功"),

    PHONE_EMPTY(301,"手机号不存在"),
    VERIFY_CODE_ERROR(302,"验证码错误"),
    PHONE_REGISTER(303,"此手机号已被注册"),
    NO_VERIFY(304,"您还未发送验证码"),
    CORRECT_VERIFY(305,"请输入正确的验证码")
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
