package com.panshi.userservice.service.impl;

import com.panshi.domail.Message;
import com.panshi.domail.user.login.inputdto.PhoneVerifyInputDTO;
import com.panshi.domail.user.register.inputdto.PhoneRegisterInputDTO;
import com.panshi.exception.BusinessException;
import com.panshi.userservice.domain.PhoneVerifyDO;
import com.panshi.userservice.domain.UserDO;
import com.panshi.userservice.mapper.RegisterMapper;
import com.panshi.userservice.mapper.UtilMapper;
import com.panshi.userservice.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 手机注册
 * @author: 蓝文娜
 * @create: 2019/08/14
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterMapper registerMapper;

    @Autowired
    private UtilMapper utilMapper;

    @Override
    public void phoneVerify(PhoneVerifyInputDTO phoneVerifyInputDTO){
        //1、判断手机号是否存在
        UserDO userDO = utilMapper.findPhone(phoneVerifyInputDTO.getPhone());
        //存在提示不可注册
        if(null != userDO){
            throw new BusinessException(Message.PHONE_REGISTER.getCode(),Message.PHONE_REGISTER.getMsg());
        }

        //2、不存在发送验证码
        PhoneVerifyDO phoneVerifyDO = new PhoneVerifyDO();
        phoneVerifyDO.setType("1");
        phoneVerifyDO.setMessage(phoneVerifyInputDTO.getVerification());
        phoneVerifyDO.setPhone(phoneVerifyInputDTO.getPhone());
        registerMapper.addVerify(phoneVerifyDO);
    }

    @Override
    public void checkout(PhoneVerifyInputDTO phoneVerifyInputDTO){
        //3、验证码是否正确
        PhoneVerifyDO verifyDO = registerMapper.queryVerify(phoneVerifyInputDTO.getPhone());
        if(verifyDO == null){
            throw new BusinessException(Message.NO_VERIFY.getCode(),Message.NO_VERIFY.getMsg());
        }
        if(!(verifyDO.getMessage().equals(phoneVerifyInputDTO.getVerification()))){
            throw new BusinessException(Message.CORRECT_VERIFY.getCode(),Message.CORRECT_VERIFY.getMsg());
        }
    }

    @Override
    public void phoneRegister(PhoneRegisterInputDTO phoneRegisterInputDTO){
        //4、注册此用户信息
        UserDO userDO = new UserDO();
        userDO.setPhone(phoneRegisterInputDTO.getPhone());
        userDO.setUsername(phoneRegisterInputDTO.getUsername());
        userDO.setPassword(phoneRegisterInputDTO.getPassword());
        userDO.setPsNum("ZC"+phoneRegisterInputDTO.getPhone());
        registerMapper.phoneAddUser(userDO);
    }
}
