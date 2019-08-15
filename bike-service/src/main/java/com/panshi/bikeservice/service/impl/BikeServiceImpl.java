package com.panshi.bikeservice.service.impl;

import com.panshi.bikeservice.bikeMapper.BikeMapper;
import com.panshi.bikeservice.domain.BikeDo;
import com.panshi.bikeservice.domain.BikeRecordDo;
import com.panshi.bikeservice.domain.ConfigDo;
import com.panshi.bikeservice.service.BikeService;
import com.panshi.domail.*;
import com.panshi.domail.outdto.OutReturnsDTO;
import com.panshi.domail.outdto.OutRideBikeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
    private StringRedisTemplate srt;

    /**
     * 查询该用户是否有预定
     * @param userid 用户id
     * @return ReturnDTO
     */
    @Override
    public ReturnDTO queryReserve(String userid) {

        String s = srt.opsForValue().get(userid);
        if(s==null){
            return new ReturnDTO(300,false,"预约已过期");
        }
        return new ReturnDTO(200,true,"数据查询成功.","1",s);
    }
    //判断是否在有效时间
    private boolean exqTime(Date cTime) {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(cTime);
        c.add(Calendar.MINUTE,15);
        return cTime.after(date);
    }

    /**
     * 解锁功能
     * @param userid 用户id
     * @param vehicleid 车辆编号
     * @return
     */
    @Override
    public OutReturnsDTO deblocking(int userid, int vehicleid) {
        String s = srt.opsForValue().get(userid);
        //根据单车编号获取数据 得到位置id和单车id
        BikeDo bikeNum = bikeMapper.getBikeNum(vehicleid);
        //判断用户是否预约  为空着不少没有预约
        if(null==s){
            //根据用户id和单车编号进行解锁
            //修改单车表的状态
            bikeMapper.updateState("1",vehicleid);
        }else {
            int i = Integer.parseInt(s);
            if(i==vehicleid){
                bikeMapper.updateState("1",i);
            }
        }
        //插入骑车记录表
        BikeRecordDo bikeRecordDTO=new BikeRecordDo(userid,vehicleid,bikeNum.getLocationId());
        bikeMapper.createRecord(bikeRecordDTO);
        return new OutReturnsDTO(200,true,"解锁成功");
    }

    /**
     *预定功能
     * @param userid 用户id
     * @param vehicleid 单车编号
     * @return
     */
    @Override
    public OutReturnsDTO reservation(int userid, int vehicleid) {
        //预约进入缓存保存15分钟
        srt.opsForValue().set("userid","vehicleid",15,TimeUnit.MINUTES);
        return new OutReturnsDTO(200,true,"预定成功");
    }

    /**
     * 关锁后支付有优惠券
     * @param userid 用户id
     * @param type 支付类型
     * @param paymentcode 支付密码
     * @param discount  优惠券
     * @return
     */
    @Override
    public OutReturnsDTO bikePay(int userid, String type, int paymentcode, float money,String discount) {

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
    public OutReturnsDTO bikePay(int userid, String type, int paymentcode,float money) {
        //判断用户的支付密码是否一致

        //判断类型
        //扣除用户金额
        //增加金额流水记录
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
