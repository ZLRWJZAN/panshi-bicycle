package com.panshi.userservice.mapper;

import com.panshi.domail.user.register.inputdto.MailboxInputDTO;
import com.panshi.userservice.domain.EmailVerifyDO;
import com.panshi.userservice.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EmailRegisterMapper {
    /**
     * 查询
     * @param username
     * @return
     */
    UserDO findUserCode(String username);

    /**
     * 查询邮箱验证最新一条信息
     * @param email
     * @return
     */
    EmailVerifyDO findEmailVerify(String email);

    /**
     * 邮箱注册用户
     * @param userDO
     */
    void emailAddUser(UserDO userDO);
}
