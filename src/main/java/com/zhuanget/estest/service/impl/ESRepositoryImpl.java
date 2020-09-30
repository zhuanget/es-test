package com.zhuanget.estest.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zhuanget.estest.config.ESClientFactory;
import com.zhuanget.estest.enums.ESMethod;
import com.zhuanget.estest.service.ESRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author Zhuang_ET
 * @since 2020-09-29 17:00:03
 */
@Service
@Slf4j
public class ESRepositoryImpl implements ESRepository {

    @Resource
    private ESClientFactory esClientFactory;

    @Override
    public boolean createIndex(String index) {
        // TODO：可以后期优化加入重试机制
        RestHighLevelClient restHighLevelClient = null;
        try {
            restHighLevelClient = getClient();
            Request request = new Request(ESMethod.PUT.getMethod(), "/" + index);
            // TODO：设置setting，mapping
            try {
                Response response = restHighLevelClient.getLowLevelClient().performRequest(request);
                log.info("response.getEntity: {}", response.getEntity());
                return true;
            } catch (IOException e) {
                log.error("some errors happen when create index: ", e);
                return false;
            }
        } finally {
            silentClose(restHighLevelClient);
        }
    }

    @Override
    public boolean createDocument(String index, Long id, JSONObject data) {
        RestHighLevelClient restHighLevelClient = null;
        try {
            restHighLevelClient = getClient();
            String endpoint = id == null ? index : index + "/" + id;
            Request request = new Request(ESMethod.POST.getMethod(), endpoint);
            HttpEntity httpEntity = new NStringEntity(data.toJSONString(), ContentType.APPLICATION_JSON);
            request.setEntity(httpEntity);
            Response response = restHighLevelClient.getLowLevelClient().performRequest(request);
            log.info("response.entity: {}", response.getEntity());
            return true;
        } catch (IOException e) {
            log.error("insert doc to index[{}] error, e: ", index, e);
        } finally {
            silentClose(restHighLevelClient);
        }
        return false;
    }

    @Override
    public boolean checkIndex(String index) {
        RestHighLevelClient restHighLevelClient = null;
        try {
            restHighLevelClient = getClient();
            GetIndexRequest request = new GetIndexRequest();
            request.indices(index);
            return restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("check index error, e: ", e);
        } finally {
            silentClose(restHighLevelClient);
        }
        return false;
    }

    @Override
    public JSONObject query(String index, Long id) {
        return null;
    }

    private RestHighLevelClient getClient() {
        return esClientFactory.newRestHighLevelClient();
    }

    private void silentClose(RestHighLevelClient restHighLevelClient) {
        if (restHighLevelClient == null) {
            return;
        }
        try {
            restHighLevelClient.close();
        } catch (IOException e) {
            log.error("restClient close failed, error: ", e);
        }
    }
}
