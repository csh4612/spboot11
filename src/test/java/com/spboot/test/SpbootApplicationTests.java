package com.spboot.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spboot.test.repository.FileRepository;
import com.spboot.test.repository.FoodInfoRepository;
import com.spboot.test.service.FileService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class SpbootApplicationTests {
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private FileRepository fileRepo;
	
	@Autowired
	private FoodInfoRepository foodRepo;

	@Test
	void contextLoads() {
		//List<FileInfo> fiList = fileService.getFileInfos(new FileInfo());
		//log.info("fiList=>{}",fiList);
		
		//log.info("fiList=>{}",fileRepo.findAll());
		
		log.info("fiList=>{}",foodRepo.findAll());
	}

}
