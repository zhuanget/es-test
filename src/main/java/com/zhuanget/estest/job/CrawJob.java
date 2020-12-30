package com.zhuanget.estest.job;

import com.zhuanget.estest.constant.SimpleBookCrawlConst;
import com.zhuanget.estest.pipeline.ESPipeline;
import com.zhuanget.estest.processor.SimpleBookProcessor;
import com.zhuanget.estest.scheduler.CountableScheduler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

/**
 * @author Zhuang_ET
 * @since 2020-12-29 21:02:20
 */
@Component
@Slf4j
public class CrawJob {

    @Autowired
    private SimpleBookProcessor simpleBookProcessor;

    @Scheduled(cron = "0 */1 * * * ?")
    public void execute() {
        log.info("****************** 爬虫开始 *******************");
        Spider.create(simpleBookProcessor)
                .addUrl(SimpleBookCrawlConst.BASE_URL)
                .setScheduler(new CountableScheduler().setCount(30))
                .addPipeline(new ESPipeline())
//                .addPipeline(new DownloadImagePipeline())
//                .addPipeline(new JsonFilePipeline("D:\\webmagic\\"))
                .thread(5)
                .run();
        log.info("****************** 爬虫结束 *******************");
    }
}
