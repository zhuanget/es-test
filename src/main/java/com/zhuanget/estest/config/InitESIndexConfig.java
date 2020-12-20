package com.zhuanget.estest.config;

import com.zhuanget.estest.constant.GlobalConst;
import com.zhuanget.estest.service.ESRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 初始化es索引
 *
 * @author Zhuang_ET
 * @since 2020-09-29 17:19:43
 */
@Component
@Order(value = Ordered.LOWEST_PRECEDENCE)
@Slf4j
public class InitESIndexConfig implements ApplicationRunner {

    @Resource
    private ESRepository esRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        String initIndex = GlobalConst.BIGDATA_ARCHIVE_INDEX;
//        boolean found = esRepository.checkIndex(initIndex);
//        if (!found) {
//            boolean success = esRepository.createIndex(initIndex, GlobalConst.NORMAL_SETTINGS);
//            log.info("init {} index {}", initIndex, success ? "success" : "fail");
//        }
        String index = GlobalConst.SIMPLE_BOOK_INDEX;
        boolean found = esRepository.checkIndex(index);
        if (!found) {
            boolean success = esRepository.createIndex(index, GlobalConst.SIMPLE_BOOK_SETTINGS);
            log.info("init es index {}", success ? "success" : "fail");
            if (success) {
                boolean mapping = esRepository.createMapping(index, GlobalConst.SIMPLE_BOOK_MAPPINGS);
                log.info("create es mapping {}", mapping ? "success" : "fail");
            }
        }
    }
}
