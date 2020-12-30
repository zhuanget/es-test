package com.zhuanget.estest;

import com.zhuanget.estest.entity.ArchiveInfo;
import com.zhuanget.estest.service.ESRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Component
@Slf4j
class EsTestApplicationTests {

	@Resource
	private ESRepository esRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void batchInsertTest() {
		String index = "bigdata_archive";
		List<ArchiveInfo> archiveInfos = new ArrayList<>();
		ArchiveInfo archiveInfo1 = new ArchiveInfo().setAid("123").setName("hello").setId(1L);
		ArchiveInfo archiveInfo2 = new ArchiveInfo().setAid("456").setName("world").setId(2L);
		archiveInfos.add(archiveInfo1);
		archiveInfos.add(archiveInfo2);
		int count = esRepository.batchInsert(archiveInfos, index);
		log.info("count: {}", count);
	}

}
