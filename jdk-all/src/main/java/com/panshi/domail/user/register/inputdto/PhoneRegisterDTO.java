package com.panshi.domail.user.register.inputdto;

import lombok.Data;

/**
 * @description: 手机注册传入对象
 * @author: 蓝文娜
 * @create: 2019/08/14
 */
@Data
public class PhoneRegisterDTO {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 验证码
     */
    private String verify;
}
