package com.panshi.userservice.service.impl;

import com.panshi.domail.Message;
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

    /**
     * 判断手机号是否存在
     * @param phone
     */
    @Override
    public void phoneRegister(String phone){
        //1、判断手机号是否存在
        UserDO userDO = utilMapper.findPhone(phone);
        //存在提示不可注册
        if(userDO != null ){
            throw new BusinessException(Message.PHONE_REGISTER.getCode(),Message.PHONE_REGISTER.getMsg());
        }
    }

    /**
     * 验证码表增加数据
     * @param code
     * @param phone
     * @return
     */
    @Override
    public int addVerifyCode(String code,String phone){
        PhoneVerifyDO phoneVerifyDO = new PhoneVerifyDO();
        phoneVerifyDO.setType("1");
        phoneVerifyDO.setMessage(code);
        phoneVerifyDO.setPhone(phone);
        return registerMapper.addVerify(phoneVerifyDO);
    }

    /**
     * 判断验证码是否正确
     * @param phone
     * @param verify
     */
    @Override
    public void checkout(String phone,String verify){
        //3、验证码是否正确
        PhoneVerifyDO verifyDO = registerMapper.queryVerify(phone);
        if(verifyDO == null){
            throw new BusinessException(Message.NO_VERIFY.getCode(),Message.NO_VERIFY.getMsg());
        }
        if(!(verifyDO.getMessage().equals(verify))){
            throw new BusinessException(Message.CORRECT_VERIFY.getCode(),Message.CORRECT_VERIFY.getMsg());
        }
    }

    /**
     * 用户注册
     * @param username
     * @param password
     * @param phone
     */
    @Override
    public void phoneRegister(String username,String password,String phone) {
        //4、注册此用户信息
        UserDO userDO = new UserDO();
        userDO.setPhone(phone);
        userDO.setPsNum("SJZC"+phone);
        userDO.setUsername(username);
        userDO.setPassword(password);
        utilMapper.phoneAddUser(userDO);
    }
}
