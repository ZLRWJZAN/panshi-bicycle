package com.panshi.userservice.service.impl;

import com.panshi.domail.Message;
import com.panshi.domail.user.register.inputdto.PhoneRegisterDTO;
import com.panshi.exception.BusinessException;
import com.panshi.userservice.domain.PhoneVerifyDO;
import com.panshi.userservice.domain.UserDO;
import com.panshi.userservice.mapper.UserMapper;
import com.panshi.userservice.mapper.UtilMapper;
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

    @Autowired
    private UtilMapper utilMapper;

    @Override
    public void phoneRegister(PhoneRegisterDTO registerDTO){
        //1、判断手机号是否存在
        UserDO userDO = utilMapper.findPhone(registerDTO.getPhone());
        //存在提示不可注册
        if(userDO != null ){
            throw new BusinessException(Message.PHONE_REGISTER.getCode(),Message.PHONE_REGISTER.getMsg());
        }

        //2、不存在发送验证码
        //生成随机数
        String str="";
        for (int i=0;i<6;i++){
            str+=(int)(Math.random()*9);
        }
        PhoneVerifyDO phoneVerifyDO = new PhoneVerifyDO();
        phoneVerifyDO.setType("1");
        phoneVerifyDO.setMessage(str);
        phoneVerifyDO.setPhone(registerDTO.getPhone());
        userMapper.addVerify(phoneVerifyDO);
    }

    @Override
    public void checkout(PhoneRegisterDTO registerDTO){
        //3、验证码是否正确
        PhoneVerifyDO verifyDO = userMapper.queryVerify(registerDTO.getPhone());
        if(verifyDO == null){
            throw new BusinessException(Message.NO_VERIFY.getCode(),Message.NO_VERIFY.getMsg());
        }
        if(!(verifyDO.getMessage().equals(registerDTO.getVerify()))){
            throw new BusinessException(Message.CORRECT_VERIFY.getCode(),Message.CORRECT_VERIFY.getMsg());
        }

        //4、注册此用户信息
        UserDO userDO = new UserDO();
        userDO.setPhone(registerDTO.getPhone());
        userDO.setPsNum("ZC"+registerDTO.getPhone());
        userMapper.phoneAddUser(userDO);
    }
}
