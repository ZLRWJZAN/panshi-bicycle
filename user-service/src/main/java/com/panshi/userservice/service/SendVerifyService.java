package com.panshi.userservice.service;

import com.arronlong.httpclientutil.exception.HttpProcessException;

public interface SendVerifyService {
    /**
     * 生成验证码
     * @return
     */
    String generateVerifynCode();

    /**
     * 发送短信验证码
     */
    int sendPhoneVerifyCode(String code,String phone)throws HttpProcessException;


    /**
     * 发送邮箱验证码
     * @return
     */
    String sendMailboxVerifynCode(String code,String email);
}
