package com.panshi.userservice.service;

import com.panshi.domail.user.login.inputdto.PhoneVerifyInputDTO;
import com.panshi.domail.user.register.inputdto.PhoneRegisterDTO;
import com.panshi.domail.user.register.inputdto.PhoneRegisterInputDTO;

public interface RegisterService {


    /**
     * 验证手机是否存在
     * @param phoneVerifyInputDTO
     * @return
     */
    void phoneRegister(PhoneVerifyInputDTO phoneVerifyInputDTO);

    /**
     * 校验验证码并注册
     * @param phoneVerifyInputDTO
     */
    void checkout(PhoneVerifyInputDTO phoneVerifyInputDTO);


    /**
     * 验证码表增加信息
     * @param code
     * @param phone
     */
    int addVerifyCode(String code,String phone);


    /**
     * 设置密码注册
     * @param phoneRegisterInputDTO
     */
    void phoneRegister(PhoneRegisterInputDTO phoneRegisterInputDTO);
}
