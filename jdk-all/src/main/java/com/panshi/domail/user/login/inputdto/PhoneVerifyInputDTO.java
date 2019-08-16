package com.panshi.domail.user.login.inputdto;

import lombok.Data;

import java.io.Serializable;

/**
 * 短信验证码inputdto
 */
@Data
public class PhoneVerifyInputDTO implements Serializable {
    /**
     * 手机号
     */
    private String phone;
    /**
     * 验证码
     */
    private String verification;
}
