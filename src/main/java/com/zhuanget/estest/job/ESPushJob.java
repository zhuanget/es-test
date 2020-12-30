package com.zhuanget.estest.job;

import com.zhuanget.estest.constant.GlobalConst;
import com.zhuanget.estest.entity.SimpleBook;
import com.zhuanget.estest.service.ESRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhuang_ET
 * @since 2020-12-29 21:07:16
 */
@Component
@Slf4j
public class ESPushJob {

    @Value("${es.batch.insert.size:20}")
    private Integer batchSize;

    @Resource
    private ESRepository esRepository;

    @Scheduled(cron = "${es.push.job.cron:*/10 * * * * ?}")
    public void execute() {
        log.info("*************** 开始执行ES数据推送 **************");
        List<SimpleBook> simpleBookList = new ArrayList<>();
        while (simpleBookList.size() < batchSize) {
            SimpleBook simpleBook = GlobalConst.SIMPLE_BOOK_BATCH_QUEUE.poll();
            if (simpleBook == null) {
                break;
            }else {
                simpleBookList.add(simpleBook);
            }
        }
        if (simpleBookList.isEmpty()) {
            return;
        }
        int count = esRepository.batchInsert(simpleBookList, GlobalConst.SIMPLE_BOOK_INDEX);
        log.info("一共往es中推入{}条数据", count);
        log.info("*************** 结束执行ES数据推送 **************");
    }
}
