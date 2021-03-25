package com.spboot.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spboot.test.entity.FileInfo;
import com.spboot.test.entity.FoodInfo;
import com.spboot.test.service.FoodInfoService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FoodInfoController {
	
	@Autowired
	private FoodInfoService fiService;
	
	@GetMapping("/foods-list")
	public @ResponseBody List<FoodInfo> getFoodInfoList(@ModelAttribute FoodInfo foodInfo) {
		return fiService.getFoodInfos(foodInfo);
		
	}
	
	@GetMapping("/food-info")
	public @ResponseBody FoodInfo getFoodInfo(@RequestParam Integer fiNum){
		return fiService.getFoodInfo(fiNum);
	}
	
	@PostMapping("/food-insert")
	public @ResponseBody Integer saveFoodInfo(@RequestBody FoodInfo foodInfo) {
		log.info("foodInfo=>{}",foodInfo);
		foodInfo = fiService.saveFoodInfo(foodInfo);
		return foodInfo.getFiNum();
	}
	
	@DeleteMapping("/food-info")
	public @ResponseBody Integer deleteFoodInfo(@RequestParam Integer fiNum) {
		return fiService.deleteFoodInfo(fiNum);
	}
	

	@PostMapping("/food-info/update")
	public @ResponseBody Integer updateFoodInfo(@RequestBody FoodInfo foodInfo) {
		foodInfo = fiService.updateFoodInfo(foodInfo);
		return foodInfo.getFiNum();
	}
	
}
