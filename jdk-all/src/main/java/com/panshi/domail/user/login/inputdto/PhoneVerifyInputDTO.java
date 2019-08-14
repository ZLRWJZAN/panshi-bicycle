package com.panshi.domail.user.login.inputdto;

import lombok.Data;

import java.io.Serializable;

/**
 * 短信验证码inputdto
 */
@Data
public class PhoneVerifyInputDTO implements Serializable {

    private String phone;

    private String verification;
}
