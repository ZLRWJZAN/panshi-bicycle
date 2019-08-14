package com.panshi.userservice.domain;

import lombok.Data;
import java.util.Date;

/**
 * @description: 用户属性DO
 * @author: 蒋文豪
 * @create: 2019/08/14
 */
@Data
public class UserDO {
    /**
     * 用户主键id
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 磐石号
     */
    private String psNum;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 创建时间
     */
    private Date cTime;
    /**
     * 修改时间
     */
    private Date upTime;
}
