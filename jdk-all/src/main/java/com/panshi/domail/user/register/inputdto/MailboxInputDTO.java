package com.panshi.domail.user.register.inputdto;

import lombok.Data;

/**
 * @description: 邮箱注册传入对象inputdto
 * @author: 蓝文娜
 * @create: 2019/08/15
 */
@Data
public class MailboxInputDTO {
    /**
     * 用户名
     */
    private String username;
    /**
     * 邮箱
     */
    private String email;

}

