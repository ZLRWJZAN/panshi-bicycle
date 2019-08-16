package com.panshi.userservice.service;

public interface RegisterService {

    /**
     * 验证手机是否存在
     * @param phone
     * @return
     */
    void phoneRegister(String phone);

    /**
     * 校验验证码
     * @param phone
     * @param verify
     */
    void checkout(String phone,String verify);

    /**
     * 验证码表增加信息
     * @param code
     * @param phone
     */
    int addVerifyCode(String code,String phone);

    /**
     * 设置密码注册
     * @param username
     * @param password
     * @param phone
     */
    void phoneRegister(String username,String password,String phone);
}
