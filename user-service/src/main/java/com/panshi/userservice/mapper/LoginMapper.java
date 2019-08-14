package com.panshi.userservice.mapper;

import com.panshi.domail.user.login.inputdto.PhoneVerifyInputDTO;
import com.panshi.userservice.domain.PhoneVerifyDO;
import com.panshi.userservice.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginMapper {


    /**
     * 判断验证码是否正确
     * @param phoneVerifyInputDTO
     * @return
     */
    PhoneVerifyDO phoneVerify(PhoneVerifyInputDTO phoneVerifyInputDTO);
}
