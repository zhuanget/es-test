package com.zhuanget.estest.pipeline;

import com.zhuanget.estest.entity.SimpleBook;
import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Slf4j
public class MySqlPipeline implements Pipeline {

    @Override
    public void process(ResultItems resultItems, Task task) {
        SimpleBook simpleBook = new SimpleBook();
        simpleBook.setTitle(resultItems.get("title"));
        simpleBook.setUser(resultItems.get("user"));
    }
}
