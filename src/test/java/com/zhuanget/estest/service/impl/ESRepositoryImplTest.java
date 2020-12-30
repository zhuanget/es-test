package com.zhuanget.estest.service.impl;

import com.zhuanget.estest.entity.ArchiveInfo;
import com.zhuanget.estest.service.ESRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@Component
@Slf4j
class ESRepositoryImplTest {

    @Resource
    private ESRepository esRepository;

    @Test
    void createIndex() {
        log.info("success");
    }

    @Test
    void createDocument() {
    }

    @Test
    void batchInsert() {

    }
}