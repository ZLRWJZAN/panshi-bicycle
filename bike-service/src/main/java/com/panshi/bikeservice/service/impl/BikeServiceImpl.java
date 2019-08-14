package com.panshi.bikeservice.service.impl;

import com.panshi.bikeservice.bikemapper.BikeMapper;
import com.panshi.bikeservice.domain.ConfigDo;
import com.panshi.bikeservice.service.BikeService;
import com.panshi.domail.RegionDTO;
import com.panshi.domail.ReturnDTO;
import com.panshi.domail.ReturnsDTO;
import com.panshi.domail.RideBikeDTO;
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

    @Override
    public ReturnDTO queryReserve(String region, String userid, int size, int page) {
        return null;
    }

    @Override
    public ReturnsDTO deblocking(int userid, int vehicleid) {
        return null;
    }

    @Override
    public RegionDTO regionQuery(Integer userId) {
        return null;
    }

    /**
     * 计费方式
     * @return
     */
    @Override
    public ConfigDo chargeMode() {
        return bikeMapper.chargeMode();
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
