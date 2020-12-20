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

    public static void main(String[] args) {
        int num = findKNumber(9, 7);
        System.out.println("num: " + num);
    }

    public static int findKNumber(int n, int k) {
        String[] ss = new String[n];
        for (int i = 1; i <= n; i++) {
            String s = i + "";
            ss[i - 1] = s;
        }
        for(int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(ss[j].compareTo(ss[i]) < 0) {
                    String tmp = ss[j];
                    ss[j] = ss[i];
                    ss[i] = tmp;
                }
            }
        }
        String t = ss[k - 1];
        return Integer.parseInt(t);
    }

    @Override
    public void execute(ShardingContext shardingContext) {
        logger.info("EtSimpleJob - {}", shardingContext.getShardingItem());
    }
}
