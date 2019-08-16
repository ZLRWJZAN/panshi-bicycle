package com.panshi.userservice.mapper;

import com.panshi.userservice.domain.EmailVerifyDO;
import com.panshi.userservice.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UtilMapper {

    /**
     * 查询手机号是否存在
     * @param phone
     */
    UserDO findPhone(String phone);

    /**
     * 用户手机注册
     * @param userDO
     */
    void phoneAddUser(UserDO userDO);

    /**
     * 增加邮箱验证信息
     * @param emailVerifyDO
     * @return
     */
    int addEmailVerify(EmailVerifyDO emailVerifyDO);
}
