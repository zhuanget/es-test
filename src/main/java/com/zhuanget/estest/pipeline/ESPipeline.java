package com.zhuanget.estest.pipeline;

import com.zhuanget.estest.constant.GlobalConst;
import com.zhuanget.estest.constant.SimpleBookCrawlConst;
import com.zhuanget.estest.entity.SimpleBook;
import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Date;
import java.util.UUID;

/**
 * 将数据刷入ES
 *
 * @author Zhuang_ET
 * @since 2020-12-29 15:43:48
 */
@Slf4j
public class ESPipeline implements Pipeline {
    @Override
    public void process(ResultItems resultItems, Task task) {
        SimpleBook simpleBook = new SimpleBook()
                .setUser(resultItems.get(SimpleBookCrawlConst.USER))
                .setName(resultItems.get(SimpleBookCrawlConst.TITLE))
                .setImageUrl(resultItems.get(SimpleBookCrawlConst.IMAGE_URL))
                .setUserHome(resultItems.get(SimpleBookCrawlConst.USER_HOME))
                .setCreateTime(new Date())
                .setUpdateTime(new Date())
                .setId(UUID.randomUUID().toString().replace("-", ""));
        GlobalConst.SIMPLE_BOOK_BATCH_QUEUE.add(simpleBook);
    }
}
