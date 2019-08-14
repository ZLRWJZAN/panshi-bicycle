package com.panshi.userservice.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author 敖嘉欣
 * @create: 2019/08/14
 */
@Data
public class EmailVerifyDO {

    //主键id
    private int id;

    //用户id
    private int userId;

    //手机号
    private String email;

    //验证码内容
    private String message;

    //发送时间
    private Date sendTime;

    //验证码类型
    private String type;

    //修改时间
    private Date upTime;
}
