package com.panshi.domail;

public enum Message {

    VERIFY_SUCCEED(200,"登录成功"),
    VERIFY_REGISTER(200,"注册成功"),

    ACCOUNT_EMPTY(501,"账号不存在"),
    ACCOUNT_PASSWORD_ERROR(502,"账号密码输入错误"),

    PHONE_EMPTY(301,"手机号不存在"),
    VERIFY_CODE_ERROR(302,"验证码错误"),
    PHONE_REGISTER(303,"此手机号已被注册"),
    NO_VERIFY(304,"您还未发送验证码"),
    CORRECT_VERIFY(305,"请输入正确的验证码"),


    REPORT_RAULR(801,"故障上报失败"),
    QUERY_ERROR(802,"查询失败"),
    PAY_ERROR(803,"支付失败"),
    PAY_PASSWORD_ERROR(804,"支付密码有误"),
    NOT_SUFFICIENT_FUNDS(805,"余额不足"),
    DELETE_MONEY_ERROR(806,"扣钱失败"),
    ADD_MONEY_WATER(807,"增加流水记录失败")
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
