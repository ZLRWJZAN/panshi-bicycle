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

    /**
     * 判断手机号是否存在
     * @param phoneVerifyInputDTO
     */
    @Override
    public void phoneRegister(PhoneVerifyInputDTO phoneVerifyInputDTO){
        //1、判断手机号是否存在
        UserDO userDO = utilMapper.findPhone(phoneVerifyInputDTO.getPhone());
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
     * @param phoneVerifyInputDTO
     */
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

    /**
     * 用户注册
     * @param phoneRegisterInputDTO
     */
    @Override
    public void phoneRegister(PhoneRegisterInputDTO phoneRegisterInputDTO) {
        //4、注册此用户信息
        UserDO userDO = new UserDO();
        userDO.setPhone(phoneRegisterInputDTO.getPhone());
        userDO.setPsNum("ZC"+phoneRegisterInputDTO.getPhone());
        userDO.setUsername(phoneRegisterInputDTO.getUsername());
        userDO.setPassword(phoneRegisterInputDTO.getPassword());
        registerMapper.phoneAddUser(userDO);
    }
}
