package com.panshi.userservice.service.impl;

import com.panshi.domail.Message;
import com.panshi.domail.user.login.inputdto.PhoneVerifyInputDTO;
import com.panshi.exception.BusinessException;
import com.panshi.userservice.domain.PhoneVerifyDO;
import com.panshi.userservice.domain.UserDO;
import com.panshi.userservice.mapper.LoginMapper;
import com.panshi.userservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    /**
     * 手机验证
     * @param phoneVerifyInputDTO
     */
    @Override
    public void verifyLogin(PhoneVerifyInputDTO phoneVerifyInputDTO) {
        //判断手机号是否存在
        UserDO user = loginMapper.findPhone(phoneVerifyInputDTO.getPhone());
        //如果不存在抛出异常
        if (user == null){
            throw new BusinessException(Message.PHONE_EMPTY.getCode(),Message.PHONE_EMPTY.getMsg());
        }
        //判断验证码是否正确
        PhoneVerifyDO phoneVerify = loginMapper.phoneVerify(phoneVerifyInputDTO);
        //如果为空则说明验证码不正确，抛出异常
        if (phoneVerify == null){
            throw new BusinessException(Message.VERIFY_CODE_ERROR.getCode(),Message.VERIFY_CODE_ERROR.getMsg());
        }
    }

    @Override
    public void login() {

    }
}
