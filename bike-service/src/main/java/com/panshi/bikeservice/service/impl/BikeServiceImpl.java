package com.panshi.bikeservice.service.impl;

import com.panshi.bikeservice.bikeMapper.BikeMapper;
import com.panshi.bikeservice.domain.*;
import com.panshi.bikeservice.service.BikeService;
import com.panshi.domail.*;
import com.panshi.domail.outdto.OutQueryFault;
import com.panshi.domail.outdto.OutReturnsDTO;
import com.panshi.domail.outdto.OutRideBikeDTO;
import com.panshi.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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

    /**
     * 判断是否在有效时间
     * @param cTime
     * @return
     */
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
     * @param userId 用户id
     * @param type 支付类型
     * @param paymentcode 支付密码
     * @param discount  优惠券
     * @param money  金额
     * @return
     */
    @Override
    @Transactional(rollbackFor = {Exception.class,Error.class,BusinessException.class,RuntimeException.class})
    public void bikePay(Integer userId, String type, String paymentcode, BigDecimal money, BigDecimal discount) {
        /**
         *  查询用户信息
         */
        AccountDo accountDo = bikeMapper.queryPayPassword(userId);
        if(accountDo==null){
            throw new BusinessException(Message.QUERY_ERROR.getCode(),Message.QUERY_ERROR.getMsg());
        }
        /**
         * 如果没有免密
         */
        if("0".equals(accountDo.getNoPassword())){
            if("".equals(paymentcode) || paymentcode==null){
                throw new BusinessException(Message.PAY_PASSWORD_ERROR.getCode(),Message.PAY_PASSWORD_ERROR.getMsg());
            }else if(accountDo.getPayPassword().equals(paymentcode)){
                pay(accountDo,userId,type,money,discount);
            }
        }else{
            pay(accountDo,userId,type,money,discount);
        }
    }

    public void pay(AccountDo accountDo,Integer userId, String type, BigDecimal money, BigDecimal discount){
        /**
         * 没有优惠券的情况
         */
        if("".equals(discount) || discount==null){
            BigDecimal subtract = accountDo.getBalance().subtract(money);
            if(subtract.compareTo(BigDecimal.ZERO)==-1){
                throw new BusinessException(Message.NOT_SUFFICIENT_FUNDS.getCode(),Message.NOT_SUFFICIENT_FUNDS.getMsg());
            }
        }else{
            BigDecimal subtract = accountDo.getBalance().subtract(money).add(discount);
            if(subtract.compareTo(BigDecimal.ZERO)==-1){
                throw new BusinessException(Message.NOT_SUFFICIENT_FUNDS.getCode(),Message.NOT_SUFFICIENT_FUNDS.getMsg());
            }
            /**
             * 将优惠券的钱减去
             */
            money=money.subtract(discount);
        }

        /**
         * 扣钱
         */
        int i = bikeMapper.deleteMoney(userId, money);
        if(i!=1) {
            throw new BusinessException(Message.DELETE_MONEY_ERROR.getCode(), Message.DELETE_MONEY_ERROR.getMsg());
        }

        /**
         * 增加金额流水记录
         */
        int i1 = bikeMapper.addMoneyWater(userId, money, type);
        if(i1!=1) {
            throw new BusinessException(Message.ADD_MONEY_WATER.getCode(), Message.ADD_MONEY_WATER.getMsg());
        }
    }

    @Override
    public RegionDTO regionQuery() {
        //使用redis进行缓存
        String region = srt.opsForValue().get("region");
        if("".equals(region)){
            List<LocationDo> list=bikeMapper.getAllRegion();
            region=list.toString();
            srt.opsForValue().set("region",region,300,TimeUnit.SECONDS);
        }
        return new RegionDTO(200,true,"地区查询成功",region);
    }

    /**
     * 查询计费方式
     * @return
     */
    @Override
    public OutReturnsDTO chargeMode() {

        ConfigDo configDo = bikeMapper.chargeMode();
        if(configDo==null){
            throw new BusinessException(Message.QUERY_ERROR.getCode(),Message.QUERY_ERROR.getMsg());
        }

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
        if(bikeRecordDo==null){
            throw new BusinessException(Message.QUERY_ERROR.getCode(),Message.QUERY_ERROR.getMsg());
        }

        OutRideBikeDTO rideBikeDTO = new OutRideBikeDTO();
        rideBikeDTO.setVehicleid(bikeRecordDo.getBikeDo().getBikeNum());
        rideBikeDTO.setVefubtime(bikeRecordDo.getBeginTime());
        rideBikeDTO.setRegion(bikeRecordDo.getLocationDo().getLocation());
        return rideBikeDTO;
    }

    /**
     *  骑行中上报故障
     * @param vehicleid	车辆编号
     * @param part 故障零件
     * @param remark 备注
     * @return
     */
    @Override
    public void reportFault(Integer userId,Integer vehicleid,String part,String remark) {
        int i = bikeMapper.reportFault(userId, vehicleid, part, remark);
        if(i!=1){
            throw new BusinessException(Message.REPORT_RAULR.getCode(),Message.REPORT_RAULR.getMsg());
        }
    }

    /**
     *车辆查询
     * @param region 地区名称
     * @param size 当前页显示条数
     * @param page 当前页数
     * @return
     */
    @Override
    public OutRideBikeDTO queryVehicle(String region, Integer size, Integer page) {
        //根据地区获取地区id
        LocationDo locationDo=bikeMapper.getlocationByLocation(region);
        //地区id获取当前全部单车
        List<BikeDo> list=bikeMapper.getBikeBylocationid(locationDo.getId(),size,page);
        OutRideBikeDTO outRideBikeDTO = new OutRideBikeDTO();
        outRideBikeDTO.setCode(200);
        outRideBikeDTO.setState(true);
        outRideBikeDTO.setMessage("数据查询成功");
        outRideBikeDTO.setData(list);
        return outRideBikeDTO;
    }

    /**
     *  上报故障
     * @param vehicleid 车辆编号
     * @param part 故障零件
     * @param remark 故障描述
     * @return
     */
    @Override
    public OutRideBikeDTO uploadingfault(Integer vehicleid, String part, String remark) {
        return null;
    }

    /**
     *  查询故障详细信息
     * @param faultId 故障id
     * @return
     */
    @Override
    public OutQueryFault faultById(Integer faultId) {
        FaultRecordDo faultRecordDo = bikeMapper.queryFault(faultId);

        OutQueryFault outQueryFault = new OutQueryFault();

        outQueryFault.setId(faultRecordDo.getId());
        outQueryFault.setBikeNum(faultRecordDo.getBikeDo().getBikeNum());
        outQueryFault.setCTime(faultRecordDo.getCTime());
        outQueryFault.setDisTime(faultRecordDo.getDisTime());
        outQueryFault.setFaultType(faultRecordDo.getFaultType());
        outQueryFault.setRemark(faultRecordDo.getRemark());
        outQueryFault.setState(faultRecordDo.getState());

        return outQueryFault;
    }

    /**
     *  查询历史故障
     * @param page 当前页
     * @param size 分页大小
     * @return
     */
    @Override
    public OutRideBikeDTO queryFault(Integer page, Integer size) {
        return null;
    }
}
