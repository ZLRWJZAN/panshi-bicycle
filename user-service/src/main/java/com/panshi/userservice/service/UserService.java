package com.panshi.userservice.service;

import com.panshi.domail.user.register.inputdto.PhoneRegisterDTO;

public interface UserService {
    /**
     * 验证手机是否存在并发送短信
     * @param registerDTO
     * @return
     */
    void phoneRegister(PhoneRegisterDTO registerDTO);

    /**
     * 校验验证码并注册
     * @param registerDTO
     */
    void checkout(PhoneRegisterDTO registerDTO);


    /**
     * 验证码表增加信息
     * @param code
     * @param phone
     */
    int addVerifyCode(String code,String phone);
}