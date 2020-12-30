package com.zhuanget.estest.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class SimpleBook {

    /**
     * 主键id
     */
    private String id;
    /**
     * 文章标题
     */
    private String name;
    /**
     * 用户头像
     */
    private String imageUrl;
    /**
     * 用户名
     */
    private String user;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 用户主页地址
     */
    private String userHome;
}
