package com.zhuanget.estest.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Zhuang_ET
 * @since 2020-09-29 19:13:58
 */
public interface ArchiveService {

    boolean insertData(JSONObject data, Long id);
}
