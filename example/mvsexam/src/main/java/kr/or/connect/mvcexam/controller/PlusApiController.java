package kr.or.connect.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.connect.mvcexam.dto.PlusResult;

@Controller
public class PlusApiController {
	@GetMapping("/api/plus")
	@ResponseBody
	public PlusResult plus(@RequestParam("value1") int value1, @RequestParam("value2") int value2) {
		PlusResult plusResult = new PlusResult();
		plusResult.setValue1(value1);
		plusResult.setValue2(value2);
		plusResult.setResult(value1 + value2);
		return plusResult;
		/*
		 * 컨트롤러 메소드가 반환하는 string값은
		 * view 이름이나 리다이렉트 경로를 의미했음
		 * 여기에서는 @ResponseBody 어노테이션을 통해
		 * 해당 메소드는 리턴한 객체를 출력하게 됨
		 * 이때 메시지 컨버터가 Bean으로 등록되어 있어야함
		 */
	}
}
