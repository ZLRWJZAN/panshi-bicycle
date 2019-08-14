package com.panshi.userservice.service.impl;

import com.panshi.domail.Message;
import com.panshi.domail.user.register.inputdto.PhoneRegisterDTO;
import com.panshi.exception.BusinessException;
import com.panshi.userservice.domain.PhoneVerifyDO;
import com.panshi.userservice.domain.UserDO;
import com.panshi.userservice.mapper.UserMapper;
import com.panshi.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: 蓝文娜
 * @create: 2019/08/14
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void phoneRegister(PhoneRegisterDTO registerDTO){
        //1、判断手机号是否存在
        UserDO userDO = userMapper.findPhone(registerDTO.getPhone());
        if(userDO.getPhone() != null || userDO.getPhone().equals("")){
            throw new BusinessException(Message.PHONE_REGISTER.getCode(),Message.PHONE_REGISTER.getMsg());
        }

        //2、发送验证码
        //生成随机数
        String str="";
        for (int i=0;i<6;i++){
            str+=(int)(Math.random()*9);
        }
        PhoneVerifyDO phoneVerifyDO = new PhoneVerifyDO();
        phoneVerifyDO.setUserId(userDO.getId());
        phoneVerifyDO.setType("1");
        phoneVerifyDO.setMessage(str);
        phoneVerifyDO.setPhone(registerDTO.getPhone());
        userMapper.addVerify(phoneVerifyDO);

        //3、验证码是否正确
        PhoneVerifyDO verifyDO = userMapper.queryVerify(registerDTO.getPhone());
        if(verifyDO == null || verifyDO.equals("")){
            throw new BusinessException(Message.NO_VERIFY.getCode(),Message.NO_VERIFY.getMsg());
        }
        if(verifyDO.getMessage() != str){
            throw new BusinessException(Message.CORRECT_VERIFY.getCode(),Message.CORRECT_VERIFY.getMsg());
        }

        //4、注册此用户信息
        register(registerDTO,userDO.getId());
        throw new BusinessException(Message.VERIFY_REGISTER.getCode(),Message.VERIFY_REGISTER.getMsg());
    }

    public void register(PhoneRegisterDTO registerDTO,Integer id){
        UserDO userDO = new UserDO();
        userDO.setUsername(registerDTO.getUsername());
        userDO.setPassword(registerDTO.getPassword());
        userDO.setPhone(registerDTO.getPhone());
        userDO.setPsNum("1000"+id);
        userMapper.phoneAddUser(userDO);
    }
}
