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
 *
 * @author Zhuang_ET
 * @since 2020-09-29 17:19:43
 */
//@Component
//@Order(value = Ordered.LOWEST_PRECEDENCE)
//@Slf4j
//public class InitESIndexConfig implements ApplicationRunner {
//
//    @Resource
//    private ESRepository esRepository;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        String initIndex = GlobalConst.BIGDATA_ARCHIVE_INDEX;
//        boolean success = esRepository.createIndex(initIndex);
//        log.info("init es index {}", success ? "success" : "fail");
//    }
//}
