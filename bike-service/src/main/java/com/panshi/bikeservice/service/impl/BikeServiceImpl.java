package com.panshi.bikeservice.service.impl;

import com.panshi.bikeservice.domain.ConfigDo;
import com.panshi.bikeservice.bikeMapper.BikeMapper;
import com.panshi.bikeservice.bikeMapper.ExpiresMapper;
import com.panshi.bikeservice.bikeMapper.LocationMapper;
import com.panshi.bikeservice.service.BikeService;
import com.panshi.domail.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*@description: 单车接口实现类
*@author: 邓俊豪
*@create: 2019/08/14
*/
@Service
public class BikeServiceImpl implements BikeService {

    @Autowired
    private BikeMapper bikeMapper;
    @Autowired
    private LocationMapper lomp;
    @Autowired
    private ExpiresMapper em;

    /**
     * 查询该用户是否有预定
     *
     * @param userid 用户id
     * @return ReturnDTO
     */
    @Override
    public ReturnDTO queryReserve(String userid) {
        //根据用户id  在预约表中获得预约对象
        ExpiresDTO expires = em.getExpiresByUserId(Integer.valueOf(userid));
        //判断对象的是否过期
        //查询数据判断用户是否已经预定
        String expires1 = expires.getExpires();
        if (expires.equals("1") && expires == null) {
            return new ReturnDTO(300, false, "预约已过期");
        }
        BikeDTO bike = bikeMapper.getBikeNum(expires.getBikeId());
        return new ReturnDTO(200, true, "数据查询成功.", "1", bike.getBikeNum());
    }

    @Override
    public OutReturnsDTO deblocking(int userid, int vehicleid) {
        return null;
    }

    @Override
    public RegionDTO regionQuery(Integer userId) {
        return null;
    }

    /**
     * 计费方式
     *
     * @return
     */
    @Override
    public OutReturnsDTO chargeMode() {

        ConfigDo configDo = bikeMapper.chargeMode();

        OutReturnsDTO returnsDTO = new OutReturnsDTO();
        returnsDTO.setBillingway(configDo.getBillingway());
        return returnsDTO;
    }

    @Override
    public RideBikeDTO rideBike(Integer userId) {
        return null;
    }

    @Override
    public ReturnDTO reportFault(Integer vehicleid, String part, String remark) {
        return null;
    }

    @Override
    public RideBikeDTO queryVehicle(String region, Integer size, Integer page) {
       return null;
    }
}
