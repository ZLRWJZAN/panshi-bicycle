package com.panshi.bikeservice.service;


import com.panshi.domail.RegionDTO;
import com.panshi.domail.ReturnDTO;
import com.panshi.domail.outdto.OutReturnsDTO;
import com.panshi.domail.outdto.OutRideBikeDTO;


public interface BikeService {
    /**
     * 查询该用户是否有预定
     * @param userid
     * @return
     */
    ReturnDTO queryReserve( String userid);

    /**
     * 解锁
     * @param userid
     * @param vehicleid
     * @return
     */
    OutReturnsDTO deblocking(int userid, int vehicleid);

    /**
     * 预定功能
     * @param userid 用户id
     * @param vehicleid 单车编号
     * @return
     */
    OutReturnsDTO reservation(int userid,int vehicleid);

    /**
     *关锁后支付无优惠券
     * @param userid
     * @param type
     * @param paymentcode
     * @param discount
     * @return
     */
    OutReturnsDTO bikePay(int userid,String type,int paymentcode,String discount);
    /**
     *关锁后支付有优惠券
     * @param userid
     * @param type
     * @param paymentcode
     * @return
     */
    OutReturnsDTO bikePay(int userid,String type,int paymentcode);
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
    OutReturnsDTO chargeMode();

    /**
     * 用户骑车功能
     * @param userId 用户名
     * @return
     */
    OutRideBikeDTO rideBike(Integer userId);

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
    OutRideBikeDTO queryVehicle(String region,Integer size,Integer page);
}
