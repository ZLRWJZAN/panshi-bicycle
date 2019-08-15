package com.panshi.bikeservice.bikeMapper;

import com.panshi.bikeservice.domain.ConfigDo;
import com.panshi.domail.BikeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author：ZLRWJSAN
 * @date 2019/8/14 9:50
 */

@Repository
@Mapper
public interface BikeMapper {

    BikeDTO getBikeNum(int bikeId);

    /**
     * 计费方式
     * @return
     */
    ConfigDo chargeMode();

    /**
     * 用户骑车功能
     * @param userId
     */
    void rideBike(Integer userId);

    void updateState(String s);
}
