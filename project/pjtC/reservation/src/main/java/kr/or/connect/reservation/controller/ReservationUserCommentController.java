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
import kr.or.connect.reservation.dto.ReservationUserComment;
import kr.or.connect.reservation.service.ReservationUserCommentService;

@RestController
@RequestMapping("api/comments")
public class ReservationUserCommentController {
	
	@Autowired
	ReservationUserCommentService reservationUserCommentService;
	
	@ApiOperation(value = "댓글 목록 구하기")
	@ApiResponses({
		@ApiResponse(code=200, message="OK"),
		@ApiResponse(code=500, message="Exception")
	})
	
	@GetMapping
	public Map<String, Object> comments(@RequestParam(value= "productId", required = false, defaultValue = "0")int productId, 
			@RequestParam(value = "start", required = false, defaultValue = "0")int start){
		Map<String, Object> map = new HashMap<>();
		List<ReservationUserComment> reservationUserCommentList;
		
		if (productId == 0) {
			reservationUserCommentList = reservationUserCommentService.getAllReservationUserComment(start);
		}
		else {
			reservationUserCommentList = reservationUserCommentService.getReservationUserCommentByProductId(productId, start);
		}
		int totalCount = reservationUserCommentService.getCount(productId);
		int commentCount = reservationUserCommentList.size();
		
		map.put("reservationUserComments", reservationUserCommentList);
		map.put("commentCount", commentCount);
		map.put("totalCount", totalCount);
		
		return map;
	}
	
}
