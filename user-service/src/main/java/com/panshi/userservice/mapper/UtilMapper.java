package com.panshi.userservice.mapper;

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
}
