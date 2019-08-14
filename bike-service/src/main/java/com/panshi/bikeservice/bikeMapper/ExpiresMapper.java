package com.panshi.bikeservice.bikeMapper;

import com.panshi.domail.ExpiresDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
*@description: 
*@author: 邓俊豪
*@create: 2019/08/14
*/
@Repository
@Mapper
public interface ExpiresMapper {
    ExpiresDTO getExpiresByUserId(int userid);
}
