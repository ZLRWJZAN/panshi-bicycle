package com.panshi.bikeservice.service.impl;

import com.panshi.bikeservice.service.BikeService;
import com.panshi.domail.ReturnDTO;
import com.panshi.domail.ReturnsDTO;
import org.springframework.stereotype.Service;

/**
*@description: 单车接口实现类
*@author: 邓俊豪
*@create: 2019/08/14
*/
@Service
public class BikeServiceImpl implements BikeService {
    /**
     * 查询该用户是否有预定
     * @param region 地区名称
     * @param userid 用户id
     * @param size 当前页显示条数
     * @param page 当前页数
     * @return ReturnDTO
     */
    @Override
    public ReturnDTO queryReserve(String region, String userid, int size, int page) {
        return null;
    }

    @Override
    public ReturnsDTO deblocking(int userid, int vehicleid) {
        return null;
    }
}
