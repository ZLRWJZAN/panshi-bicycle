package com.panshi.domail.user.register.inputdto;

import lombok.Data;
import java.io.Serializable;

/**
 * @description: 手机设置密码注册inputdto
 * @author: 蓝文娜
 * @create: 2019/08/15
 */
@Data
public class PhoneRegisterInputDTO implements Serializable {
    /**
     * 手机号
     */
    private String phone;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}
