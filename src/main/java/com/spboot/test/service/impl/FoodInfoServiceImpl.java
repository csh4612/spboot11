package com.spboot.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spboot.test.entity.FoodInfo;
import com.spboot.test.repository.FoodInfoRepository;
import com.spboot.test.service.FoodInfoService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FoodInfoServiceImpl implements FoodInfoService {
	
	@Autowired
	private FoodInfoRepository fiRepo;

	@Override
	public List<FoodInfo> getFoodInfos(FoodInfo foodInfo) {
		return fiRepo.findAllByOrderByFiNumAsc();
	}

	@Override
	public FoodInfo getFoodInfo(Integer fiNum) {
		Optional<FoodInfo> opFi = fiRepo.findById(fiNum);
		if(opFi.isEmpty()) return null;
		return opFi.get();
	}

	@Override
	public FoodInfo saveFoodInfo(FoodInfo foodInfo) {
		log.info("foodInfo=>{}",foodInfo);
		return fiRepo.save(foodInfo);
	}

	@Override
	public FoodInfo updateFoodInfo(FoodInfo foodInfo) {
		return fiRepo.save(foodInfo);
	}

	@Override
	public int deleteFoodInfo(Integer fiNum) {
		fiRepo.deleteById(fiNum);
		if(getFoodInfo(fiNum)==null) {
			return 1;
		}
		return 0;
	}

}
