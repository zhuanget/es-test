package com.zhuanget.estest.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zhuanget.estest.constant.GlobalConst;
import com.zhuanget.estest.service.ArchiveService;
import com.zhuanget.estest.service.ESRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @author Zhuang_ET
 * @since 2020-09-29 19:15:07
 */
@Service
public class ArchiveServiceImpl implements ArchiveService {

    @Autowired
    private ESRepository esRepository;

    @Override
    public boolean insertData(JSONObject data, Long id) {
        return esRepository.createDocument(GlobalConst.BIGDATA_ARCHIVE_INDEX, id, data);
    }
}
