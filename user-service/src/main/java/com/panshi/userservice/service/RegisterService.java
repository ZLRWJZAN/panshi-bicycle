package com.panshi.userservice.service;

import com.panshi.domail.user.login.inputdto.PhoneVerifyInputDTO;
import com.panshi.domail.user.register.inputdto.PhoneRegisterInputDTO;

public interface RegisterService {
    /**
     * 验证手机是否存在并发送短信
     * @param phoneVerifyInputDTO
     * @return
     */
    void phoneVerify(PhoneVerifyInputDTO phoneVerifyInputDTO);

    /**
     * 校验验证码
     * @param phoneVerifyInputDTO
     */
    void checkout(PhoneVerifyInputDTO phoneVerifyInputDTO);

    /**
     * 设置密码注册
     * @param phoneRegisterInputDTO
     */
    void phoneRegister(PhoneRegisterInputDTO phoneRegisterInputDTO);
}
