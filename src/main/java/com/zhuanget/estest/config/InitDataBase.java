package com.zhuanget.estest.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Zhuang_ET
 * @since 2020-10-14 11:30:46
 */
@Configuration
@Slf4j
public class InitDataBase implements ApplicationListener<ContextRefreshedEvent> {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        new Thread(() -> {
            try {
                initDataBase(contextRefreshedEvent);
            } catch (Exception e) {
                log.error("database connect error! e: ", e);
            }
        }).start();
    }

    public void initDataBase(ContextRefreshedEvent event) throws SQLException, IOException {
        Connection connection = DriverManager.getConnection(url, username, password);
        ScriptRunner scriptRunner = new ScriptRunner(connection);
        scriptRunner.setErrorLogWriter(null);
        scriptRunner.setLogWriter(null);
        scriptRunner.runScript(Resources.getResourceAsReader("initData/project_init.sql"));
        connection.close();
        log.info("============== success ===============");
    }
}
