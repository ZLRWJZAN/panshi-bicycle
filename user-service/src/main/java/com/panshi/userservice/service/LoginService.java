package com.panshi.userservice.service;

import com.panshi.domail.user.login.inputdto.PhoneVerifyInputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;



public interface LoginService {

    /**
     * 手机验证
     */
    void verifyLogin(PhoneVerifyInputDTO phoneVerifyInputDTO);


    /**
     * 账号密码登录
     */
    void login();
}
