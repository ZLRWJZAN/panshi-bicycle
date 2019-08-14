package com.panshi.bikeservice.bikemapper;

import com.panshi.bikeservice.domain.ConfigDo;
import com.panshi.domail.ReturnsDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author：ZLRWJSAN
 * @date 2019/8/14 9:50
 */

@Repository
@Mapper
public interface BikeMapper {
    /**
     * 计费方式
     * @return
     */
    ConfigDo chargeMode();
}
