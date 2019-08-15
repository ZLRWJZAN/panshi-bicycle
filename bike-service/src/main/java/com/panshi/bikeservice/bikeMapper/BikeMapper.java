package com.panshi.bikeservice.bikeMapper;

import com.panshi.bikeservice.domain.BikeRecordDo;
import com.panshi.bikeservice.domain.ConfigDo;
import com.panshi.domail.BikeDTO;
import com.panshi.domail.BikeRecordDTO;
import com.panshi.domail.ExpiresDTO;
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
     * 根据编号获得单车对象
     * @param bikeId
     * @return
     */
    BikeDTO getBikeNum(int bikeId);

    /**
     * 计费方式
     * @return
     */
    ConfigDo chargeMode();

    /**
     * 骑车中查询信息
     * @param userId
     */
    BikeRecordDo rideBike(Integer userId);

    /**
     * 修改状态
     * @param s
     */
    void updateState(String s);

    /**
     * 增加骑车记录
     * @param bikeRecordDTO
     */
    void createRecord(BikeRecordDTO bikeRecordDTO);

    /**
     * 根据userid 获得预约对象
     * @param userid
     * @return
     */
    ExpiresDTO getExpiresByUserId(int userid);


}
