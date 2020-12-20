package com.zhuanget.estest.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Zhuang_ET
 * @since 2020-09-29 16:53:56
 */
public interface ESRepository {

    /**
     * 创建索引
     * @param index
     * @param setting
     * @return 创建状态
     */
    boolean createIndex(String index, String setting);

    /**
     * 创建映射关系
     * @param index
     * @param mapping
     * @return
     */
    boolean createMapping(String index, String mapping);

    /**
     * 创建document
     * @param index
     * @param id
     * @param data
     * @return
     */
    boolean createDocument(String index, Long id, JSONObject data);

    /**
     * 检查索引是否存在
     * @param index
     * @return
     */
    boolean checkIndex(String index);

    /**
     * 查询数据
     * @param index
     * @param id
     * @return
     */
    JSONObject query(String index, Long id);
}
