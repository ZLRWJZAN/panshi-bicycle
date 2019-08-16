package com.panshi.userservice.service;

import com.panshi.domail.user.register.inputdto.MailboxInputDTO;

public interface EmailRegisterService {
    void emailRegister(MailboxInputDTO mailboxInputDTO);
    int addEmailCode(String code,String email);
    void emailCheckout(String email,String verify);
    void phoneRegister(String username,String password,String email);
}
