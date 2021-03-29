package com.spboot.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spboot.test.entity.CustomerInfo;
import com.spboot.test.entity.FoodInfo;
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
		FoodInfo fi = new FoodInfo();
		fi.setFiName("떡볶이");
		fi.setFiPrice(4000);
		fi.setFiType("분식");
		fi.setFiDesc("떡볶이 맛있따");
		CustomerInfo ci = new CustomerInfo();
		log.info("ciNum=>{}",ci.getCuiNum());
		ci.setCuiNum(1);
		fi.setCustomerInfo(ci);
		
		fi = foodRepo.save(fi);
		log.info("fi=>{}",fi);
		
	}

}
