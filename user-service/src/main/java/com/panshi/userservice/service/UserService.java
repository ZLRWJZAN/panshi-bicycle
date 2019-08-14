package com.panshi.userservice.service;

import com.panshi.domail.user.register.inputdto.PhoneRegisterDTO;

public interface UserService {
    /**
     * 验证手机是否存在并发送短信注册
     * @param registerDTO
     * @return
     */
    void phoneRegister(PhoneRegisterDTO registerDTO);
}
