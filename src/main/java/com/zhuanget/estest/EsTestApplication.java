package com.zhuanget.estest;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.zhuanget.estest.job.EtSimpleJob;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EsTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsTestApplication.class, args);
    }

//    private static CoordinatorRegistryCenter createRegistryCenter() {
//        CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(
//                new ZookeeperConfiguration("127.0.0.1:2181,192.168.11.112:32181", "elastic-job-et"));
//        regCenter.init();
//        return regCenter;
//    }
//
//    private static LiteJobConfiguration createJobConfiguration() {
//        // 定义作业核心配置
//        JobCoreConfiguration simpleCoreConfig = JobCoreConfiguration.newBuilder("demoSimpleJob", "0/50 * * * * ?", 5).build();
//
//        // 定义SIMPLE类型配置
//        SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(simpleCoreConfig, EtSimpleJob.class.getCanonicalName());
//
//        // 定义Lite作业根配置
//        return LiteJobConfiguration.newBuilder(simpleJobConfig).build();
//    }
//
//    @Bean
//    public CommandLineRunner commandLineRunner() {
//        return (String... args) -> {
//            new JobScheduler(createRegistryCenter(), createJobConfiguration()).init();
//        };
//    }

}
