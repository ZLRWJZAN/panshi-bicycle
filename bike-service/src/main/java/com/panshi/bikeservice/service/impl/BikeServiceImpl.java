package com.panshi.bikeservice.service.impl;

import com.panshi.bikeservice.bikeMapper.BikeMapper;
import com.panshi.bikeservice.bikeMapper.ExpiresMapper;
import com.panshi.bikeservice.bikeMapper.LocationMapper;
import com.panshi.bikeservice.service.BikeService;
import com.panshi.domail.BikeDTO;
import com.panshi.domail.ExpiresDTO;
import com.panshi.domail.ReturnDTO;
import com.panshi.domail.ReturnsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    private LocationMapper lomp;
    @Autowired
    private ExpiresMapper em;

    /**
     * 查询该用户是否有预定
     * @param userid 用户id
     * @return ReturnDTO
     */
    @Override
    public ReturnDTO queryReserve(String userid) {
        //根据用户id  在预约表中获得预约对象
        ExpiresDTO expires=em.getExpiresByUserId(Integer.valueOf(userid));
        //判断对象的是否过期
        //查询数据判断用户是否已经预定
        String expires1 = expires.getExpires();
        if(expires.equals("1")&&expires==null){
            return new ReturnDTO(300,false,"预约已过期");
        }
        BikeDTO bike=bikeMapper.getBikeNum(expires.getBikeId());
        return new ReturnDTO(200,true,"数据查询成功.","1",bike.getBikeNum());
    }

    /**
     * 解锁功能
     * @param userid 用户id
     * @param vehicleid 车辆编号
     * @return
     */
    @Override
    public ReturnsDTO deblocking(int userid, int vehicleid) {
        //根据用户id和单车编号进行解锁

        //根据单车编号获取数据 得到位置id和单车id

        //插入骑车记录表

        //修改单车表的状态

        return null;
    }
}
