package com.panshi.bikeservice.service;

import com.panshi.domail.ReturnDTO;
import com.panshi.domail.ReturnsDTO;

public interface BikeService {
    //查询该用户是否有预定
    ReturnDTO queryReserve( String userid);

    //解锁
    ReturnsDTO deblocking(int userid, int vehicleid);


    /**
     * 地区查询
     * @param userId 用户名
     * @return
     */
    RegionDTO regionQuery(Integer userId);

    /**
     * 计费方式
     * @return
     */
    ConfigDo chargeMode();

    /**
     * 用户骑车功能
     * @param userId 用户名
     * @return
     */
    RideBikeDTO rideBike(Integer userId);

    /**
     * 骑行中上报故障
     * @param vehicleid	车辆编号
     * @param part 故障零件
     * @param remark 备注
     * @return
     */
    ReturnDTO reportFault(Integer vehicleid,String part,String remark);

    /**
     * 车辆查询
     * @param region 地区名称
     * @param size 当前页显示条数
     * @param page 当前页数
     * @return
     */
    RideBikeDTO queryVehicle(String region,Integer size,Integer page);
}
