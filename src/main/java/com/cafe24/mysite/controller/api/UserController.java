package com.cafe24.mysite.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.mysite.dto.JSONResult;
import com.cafe24.mysite.service.UserService;


@Controller("userAPIController") 
@RequestMapping("/user/api")
// HandlerMapping에 컨트롤러 클래스 등록할때 클래스명으로 등록을 하게되는데 같은 이름이 있을경우 오류가 난다. 그래서 설정해줌
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/checkemail")
	public JSONResult checkEmail(
			@RequestParam(value="checkemail", required=true, defaultValue="") String email) {
		System.out.println("email: "+email);
			Boolean exist = userService.existEmail(email);
			
		return JSONResult.success(exist);
	}

	
}
