package com.panshi.bikeservice.bikeMapper;

import com.panshi.bikeservice.domain.BikeDo;
import com.panshi.bikeservice.domain.BikeRecordDo;
import com.panshi.bikeservice.domain.ConfigDo;
import com.panshi.bikeservice.domain.ExpiresDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
    BikeDo getBikeNum(@Param("bikeId") int bikeId);

    /**
     * 计费方式
     * @return
     */
    ConfigDo chargeMode();

    /**
     * 用户骑车功能
     * @param userId
     */
    BikeRecordDo rideBike(Integer userId);

    /**
     * 修改状态
     * @param s
     */
    void updateState(String s,int id);

    /**
     * 增加骑车记录
     * @param bikeRecordDTO
     */
    void createRecord(BikeRecordDo bikeRecordDTO);

    /**
     * 根据userid 获得预约对象
     * @param userid
     * @return
     */
    ExpiresDo getExpiresByUserId(int userid);


}
