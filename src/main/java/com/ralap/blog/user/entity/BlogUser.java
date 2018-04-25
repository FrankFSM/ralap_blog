package com.ralap.blog.user.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 博客用户
 *
 * @author: ralap
 * @date: created at 2018/4/18 22:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogUser {

    /**
     * 主键
     */
    private Long userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String userPwd;
    /**
     * 生日
     */
    private String userBirthday;

    /**
     * 手机号
     */
    private Long userPhone;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 头像路径
     */
    private String userImageUrl;
    /**
     * 职业
     */
    private String userProfession;
    /**
     * 性别
     */
    private int userSex;
    /**
     * 年龄
     */
    private int userAge;
    /**
     * 角色
     */
    private String userPower;
    /**
     * 用户地址
     */
    private String userAddress;
    /**
     * 用户状态
     */
    private Integer userStatus;
    /**
     * 上次的登录IP
     */
    private String userLastLoginIp;
    /**
     *上次登录时间
     */
    private Date userLastUpdateTime;
    /**
     * 简介
     */
    private String userDescription;
    /**
     * 备注
     */
    private String remake;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

}
