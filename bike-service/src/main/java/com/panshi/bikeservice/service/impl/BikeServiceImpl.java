package com.panshi.bikeservice.service.impl;

import com.panshi.bikeservice.bikeMapper.BikeMapper;
import com.panshi.bikeservice.domain.BikeRecordDo;
import com.panshi.bikeservice.domain.ConfigDo;
import com.panshi.bikeservice.service.BikeService;
import com.panshi.domail.*;
import com.panshi.domail.outdto.OutReturnsDTO;
import com.panshi.domail.outdto.OutRideBikeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
*@description: 单车接口实现类
*@author: 邓俊豪
*@create: 2019/08/14
*/
@Service
public class BikeServiceImpl implements BikeService {
    @Autowired
    private BikeMapper bikeMapper;



    //判断是否在有效时间
    private boolean exqTime(Date cTime) {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(cTime);
        c.add(Calendar.MINUTE,15);
        return cTime.after(date);
    }


    @Override
    public ReturnDTO queryReserve(String userid) {
        return null;
    }

    @Override
    public OutReturnsDTO deblocking(int userid, int vehicleid) {
        return null;
    }

    @Override
    public OutReturnsDTO reservation(int userid, int vehicleid) {
        return null;
    }

    /**
     *关锁后支付有优惠券
     * @param userid 用户id
     * @param type 支付类型
     * @param paymentcode 支付密码
     * @param discount  优惠券
     * @return
     */
    @Override
    public OutReturnsDTO bikePay(int userid, String type, int paymentcode, String discount) {

        return null;
    }

    /**
     * 关锁后支付无有优惠券
     * @param userid 用户id
     * @param type 支付类型
     * @param paymentcode 支付密码
     * @return
     */
    @Override
    public OutReturnsDTO bikePay(int userid, String type, int paymentcode) {

        return null;
    }

    @Override
    public RegionDTO regionQuery(Integer userId) {
        return null;
    }

    /**
     * 查询计费方式
     * @return
     */
    @Override
    public OutReturnsDTO chargeMode() {

        ConfigDo configDo = bikeMapper.chargeMode();

        OutReturnsDTO outReturnsDTO = new OutReturnsDTO();

        outReturnsDTO.setBillingway(configDo.getBillingway());

        return outReturnsDTO;
    }

    /**
     * 骑车中查询信息
     * @param userId 用户名
     * @return
     */
    @Override
    public OutRideBikeDTO rideBike(Integer userId) {
        BikeRecordDo bikeRecordDo = bikeMapper.rideBike(userId);
        OutRideBikeDTO rideBikeDTO = new OutRideBikeDTO();
        rideBikeDTO.setVehicleid(bikeRecordDo.getBikeDo().getBikeNum());
        rideBikeDTO.setVefubtime(bikeRecordDo.getBeginTime());
        rideBikeDTO.setRegion(bikeRecordDo.getLocationDo().getLocation());
        return rideBikeDTO;
    }

    @Override
    public ReturnDTO reportFault(Integer vehicleid, String part, String remark) {
        return null;
    }

    @Override
    public OutRideBikeDTO queryVehicle(String region, Integer size, Integer page) {
        return null;
    }
}
