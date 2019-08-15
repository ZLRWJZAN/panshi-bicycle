package com.panshi.userservice.service;

import com.panshi.domail.user.register.inputdto.PhoneRegisterDTO;

public interface UserService {
    /**
     * 验证手机是否存在并发送短信
     * @param phone
     * @return
     */
    void phoneRegister(String phone);

    /**
     * 校验验证码并注册
     * @param registerDTO
     */
    void checkout(PhoneRegisterDTO registerDTO);
}
