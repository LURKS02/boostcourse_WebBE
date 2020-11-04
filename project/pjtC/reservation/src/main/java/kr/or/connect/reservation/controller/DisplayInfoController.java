package kr.or.connect.reservation.controller;

import java.util.ArrayList;
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
import kr.or.connect.reservation.dto.DisplayInfoImage;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.service.DisplayInfoImageService;
import kr.or.connect.reservation.service.DisplayInfoService;
import kr.or.connect.reservation.service.ProductImageService;

@RestController
@RequestMapping("api/displayinfos")
public class DisplayInfoController {

	@Autowired
	DisplayInfoService displayInfoService;
	@Autowired
	ProductImageService productImageService;
	@Autowired
	DisplayInfoImageService displayInfoImageService;
	
	@ApiOperation(value = "상품 목록 구하기")
	@ApiResponses({
		@ApiResponse(code=200, message="OK"),
		@ApiResponse(code=500, message="Exception")
	})
	@GetMapping
	public Map<String, Object> items(@RequestParam(value = "displayInfoId", required=false, defaultValue="0")int displayInfoId, @RequestParam(value="categoryId", required=false, defaultValue="0")int id, 
			@RequestParam(value="start", required=false, defaultValue="0")int start) {  
		
		Map<String, Object> map = new HashMap<>();
		if (displayInfoId != 0) {
			List<DisplayInfo> displayInfo = displayInfoService.getDisplayInfoByProductId(displayInfoId);
			List<ProductImage> productImage = productImageService.getAllProductImage(displayInfoId);
			List<DisplayInfoImage> displayInfoImage = displayInfoImageService.getAllDisplayInfoImage(displayInfoId);
			
			map.put("product", displayInfo);
			map.put("productImages", productImage);
			map.put("displayInfoImages", displayInfoImage);
		}
		
		else {
			List<DisplayInfo> displayInfoList;
			if (id != 0) {
				displayInfoList = displayInfoService.getDisplayInfoByCategory(id, start);
			}
			else {
				displayInfoList = displayInfoService.getAllDisplayInfo(start);
			}
		
			int totalCount = displayInfoService.getCount(id);
			int pageCount = totalCount / displayInfoService.DISPLAY_LIMIT;
			if (totalCount % displayInfoService.DISPLAY_LIMIT > 0)
				pageCount++;
		
			List<Integer> pageStartList = new ArrayList<>();
			for (int i = 0; i < pageCount; i++) {
				pageStartList.add(i * displayInfoService.DISPLAY_LIMIT);
			}
		
		
			int productCount = displayInfoList.size();
		
			map.put("products", displayInfoList);
			map.put("productCount", productCount);
			map.put("totalCount", totalCount);
		}
		return map;
	}
	
}
