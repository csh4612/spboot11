package com.spboot.test.service;

import com.spboot.test.entity.CustomerInfo;

public interface CustomerInfoService {

	public CustomerInfo login(CustomerInfo customerInfo);
	
	public CustomerInfo getCustomerInfoById(Integer cuiNum);
}
