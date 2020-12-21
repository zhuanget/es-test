package com.zhuanget.estest.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CrawlImage {

    private Integer id;

    private String name;

    private String imageUrl;

    private String user;

    private Date createTime;

    private String userHome;
}
