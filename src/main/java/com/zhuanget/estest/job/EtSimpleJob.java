package com.zhuanget.estest.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * elastic-job 测试
 * @author Zhuang_ET
 * @since 2020-09-30 16:15:49
 */
public class EtSimpleJob implements SimpleJob {

    private static Logger logger = LoggerFactory.getLogger(EtSimpleJob.class);

    @Override
    public void execute(ShardingContext shardingContext) {
        logger.info("EtSimpleJob - {}", shardingContext.getShardingItem());
    }
}
