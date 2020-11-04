package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.PromotionService;

@RestController
@RequestMapping("api/promotions")
public class PromotionController {
	@Autowired
	PromotionService promotionService;
	
	@ApiOperation(value = "프로모션 목록 구하기")
	@ApiResponses({
		@ApiResponse(code=200, message="OK"),
		@ApiResponse(code=500, message="Exception")
	})
	
	@GetMapping
	public Map<String, Object> promotions(){
		List<Promotion> list = promotionService.getAllPromotion();
		int count = promotionService.getCount();
		Map<String, Object> map = new HashMap<>();
		map.put("items", list);
		map.put("size", count);
		return map;
	}
	
}
