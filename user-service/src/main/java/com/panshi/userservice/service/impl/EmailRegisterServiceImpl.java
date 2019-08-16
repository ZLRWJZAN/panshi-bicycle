package com.panshi.userservice.service.impl;

import com.panshi.domail.Message;
import com.panshi.domail.user.register.inputdto.MailboxInputDTO;
import com.panshi.exception.BusinessException;
import com.panshi.userservice.domain.EmailVerifyDO;
import com.panshi.userservice.domain.UserDO;
import com.panshi.userservice.mapper.EmailRegisterMapper;
import com.panshi.userservice.mapper.UtilMapper;
import com.panshi.userservice.service.EmailRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 邮箱注册
 * @author: 蓝文娜
 * @create: 2019/08/15
 */
@Service
public class EmailRegisterServiceImpl implements EmailRegisterService {
    @Autowired
    private EmailRegisterMapper emailRegisterMapper;

    @Autowired
    private UtilMapper utilMapper;

    /**
     * 校验用户名和邮箱是否存在
     * @param mailboxInputDTO
     */
    @Override
    public void emailRegister(MailboxInputDTO mailboxInputDTO){
        //1、判断用户名是否存在
        UserDO userDO = emailRegisterMapper.findUserCode(mailboxInputDTO.getUsername());
        if(null != userDO){
            throw new BusinessException(Message.USER_EXIST.getCode(),Message.USER_EXIST.getMsg());
        }
        //2、判断邮箱是否存在
        UserDO userCode = emailRegisterMapper.findUserCode(mailboxInputDTO.getEmail());
        if(null != userCode){
            throw new BusinessException(Message.EMAIL_EXIST.getCode(),Message.EMAIL_EXIST.getMsg());
        }
    }

    /**
     * 增加邮箱验证码信息
     * @param code
     * @param email
     * @return
     */
    @Override
    public int addEmailCode(String code, String email){
        EmailVerifyDO emailVerifyDO = new EmailVerifyDO();
        emailVerifyDO.setType("1");
        emailVerifyDO.setMessage(code);
        emailVerifyDO.setEmail(email);
        return utilMapper.addEmailVerify(emailVerifyDO);
    }

    /**
     * 邮箱校验验证码是否正确
     * @param email
     * @param verify
     */
    @Override
    public void emailCheckout(String email,String verify){
        EmailVerifyDO emailVerifyDO = emailRegisterMapper.findEmailVerify(email);
        if(emailVerifyDO == null){
            throw new BusinessException(Message.NO_VERIFY.getCode(),Message.NO_VERIFY.getMsg());
        }
        if(!(emailVerifyDO.getMessage().equals(verify))){
            throw new BusinessException(Message.CORRECT_VERIFY.getCode(),Message.CORRECT_VERIFY.getMsg());
        }
    }

    /**
     * 邮箱注册
     * @param username
     * @param password
     * @param email
     */
    @Override
    public void phoneRegister(String username,String password,String email) {
        //4、注册此用户信息
        UserDO userDO = new UserDO();
        userDO.setEmail(email);
        String[] split = email.split("@");
        userDO.setPsNum("YXZC"+split[0]);
        userDO.setUsername(username);
        userDO.setPassword(password);
        emailRegisterMapper.emailAddUser(userDO);
    }
}
