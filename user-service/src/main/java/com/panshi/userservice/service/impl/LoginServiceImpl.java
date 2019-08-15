package com.panshi.userservice.service.impl;

import com.panshi.domail.Message;
import com.panshi.domail.user.login.inputdto.LoginInputDTO;
import com.panshi.domail.user.login.inputdto.PhoneVerifyInputDTO;
import com.panshi.exception.BusinessException;
import com.panshi.userservice.domain.PhoneVerifyDO;
import com.panshi.userservice.domain.UserDO;
import com.panshi.userservice.mapper.LoginMapper;
import com.panshi.userservice.mapper.UtilMapper;
import com.panshi.userservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private UtilMapper utilMapper;

    /**
     * 手机验证登录
     * @param phoneVerifyInputDTO
     */
    @Override
    public void verifyLogin(PhoneVerifyInputDTO phoneVerifyInputDTO) {
        //判断手机号是否存在
        UserDO user = utilMapper.findPhone(phoneVerifyInputDTO.getPhone());
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

    /**
     * 账号密码登录
     * @param loginInputDTO
     */
    @Override
    public void login(LoginInputDTO loginInputDTO) {
        //判断账号是否存在
        UserDO boolAccount = loginMapper.findAccount(loginInputDTO.getUsername());

        //如果为空 则说明账号不存在
        if (boolAccount == null){
            throw new BusinessException(Message.ACCOUNT_EMPTY.getCode(),Message.ACCOUNT_EMPTY.getMsg());
        }

        //验证账号密码是否正确
        UserDO user = loginMapper.loginVerify(loginInputDTO);

        //如果为空则说明账号密码不正确
        if (user == null){
            throw  new BusinessException(Message.ACCOUNT_PASSWORD_ERROR.getCode(),Message.ACCOUNT_PASSWORD_ERROR.getMsg());
        }
    }
}
