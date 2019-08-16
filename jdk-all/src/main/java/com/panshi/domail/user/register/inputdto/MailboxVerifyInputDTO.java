package com.panshi.domail.user.register.inputdto;

import lombok.Data;

/**
 * @description: 邮箱验证码传入对象inputdto
 * @author: 蓝文娜
 * @create: 2019/08/15
 */
@Data
public class MailboxVerifyInputDTO {
    /**
     * 邮箱
     */
    private String email;
    /**
     * 验证码
     */
    private String verify;
}
