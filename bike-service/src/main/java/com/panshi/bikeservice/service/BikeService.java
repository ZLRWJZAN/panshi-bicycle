package com.panshi.bikeservice.service;

import com.panshi.domail.ReturnDTO;
import com.panshi.domail.ReturnsDTO;

public interface BikeService {
    //查询该用户是否有预定
    ReturnDTO queryReserve(String region, String userid,int size,int page);
    //解锁
    ReturnsDTO deblocking(int userid, int vehicleid);
    //地区查询
}
