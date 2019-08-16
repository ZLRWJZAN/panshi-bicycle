package com.panshi.bikeservice.bikeMapper;

import com.panshi.bikeservice.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

import java.util.List;

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
     * @param
     */
    void updateState(@Param("s")String state,@Param("vehicleid")int vid);

    /**
     * 增加骑车记录
     * @param bikeRecordDTO
     */
    void createRecord(BikeRecordDo bikeRecordDTO);


    /**
     * 骑行中上报故障
     * @param userId
     * @param vehicleid
     * @param part
     * @param remark
     * @return
     */
    int reportFault(Integer userId,Integer vehicleid, String part, String remark);

    /**
     * 查询用户信息
     * @param userId 用户id
     * @return
     */
    AccountDo queryPayPassword(Integer userId);

    /**
     * 扣钱
     * @param userId 用户id
     * @param money 金额
     * @return
     */
    int deleteMoney(Integer userId, BigDecimal money);

    /**
     * 增加金额流水记录
     * @param userId
     * @param money
     * @param type
     * @return
     */
    int addMoneyWater(Integer userId, BigDecimal money, String type);

    /**
     * 获取全部地区
     * @return
     */
    List<LocationDo> getAllRegion();

    /**
     * 根据location获得对象
     * @param location
     * @return
     */
    LocationDo getlocationByLocation(@Param("location") String location);

    /**
     * 获取当前地区的全部单车
     * @param id
     * @param size
     * @param page
     * @return
     */
    List<BikeDo> getBikeBylocationid(@Param("id")Integer id,@Param("size") Integer size, @Param("page")Integer page);

    /**
     * 查询故障详细信息
     * @param faultId
     */
    FaultRecordDo queryFault(Integer faultId);
    //增加数据到故障记录表
    void createRecordFault(RecordFaultDo recordFaultDo);

}
