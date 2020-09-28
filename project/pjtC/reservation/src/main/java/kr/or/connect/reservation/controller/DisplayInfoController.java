package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.service.DisplayInfoService;
import kr.or.connect.reservation.service.ProductService;

@RestController
@RequestMapping("api/displayinfos")
public class DisplayInfoController {

	@Autowired
	DisplayInfoService displayInfoService;
	@Autowired
	ProductService productService;
	
	@ApiOperation(value = "상품 목록 구하기")
	@ApiResponses({
		@ApiResponse(code=200, message="OK"),
		@ApiResponse(code=500, message="Exception")
	})
	@GetMapping
	public Map<String, Object> items(@RequestParam(value="categoryId", defaultValue="0")int id, @RequestParam(value="start", required=false)int start) {  
		
		Map<String, Object> map = new HashMap<>();
		List<DisplayInfo> displayInfoList = displayInfoService.getAllDisplayInfo();
		int totalCount = productService.getCountByCategoryId(id);
		int productCount = displayInfoService.DISPLAY_LIMIT;
		map.put("products", displayInfoList);
		map.put("productCount", productCount);
		map.put("totalCount", totalCount);
		return map;
	}
	
}
