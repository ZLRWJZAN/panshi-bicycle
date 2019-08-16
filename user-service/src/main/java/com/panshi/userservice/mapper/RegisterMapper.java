package com.panshi.userservice.mapper;

import com.panshi.userservice.domain.PhoneVerifyDO;
import com.panshi.userservice.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RegisterMapper {
    /**
     * 用户手机注册
     * @param userDO
     */
    void phoneAddUser(UserDO userDO);

    /**
     * 验证码表增加一条数据
     * @param phoneVerifyDO
     */
    int addVerify(PhoneVerifyDO phoneVerifyDO);

    /**
     * 查询此手机号最进的一条验证码内容
     * @param phone
     * @return
     */
    PhoneVerifyDO queryVerify(String phone);
}
