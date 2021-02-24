package com.cos.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.controller.dto.ResponseDto;
import com.cos.blog.model.Board;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userservice;
	
//	@Autowired
//	private HttpSession session; //세션객체 스프링컨테이너가 빈으로 등록해서 가지고 있음// 필요시 DI에 등록해서 사용
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) { //받는값 username, pwd, email
		System.out.println("UserApiController : save 호출됨" );
		// 실제로 DB에 insert를 하고 아래에서 return이 되면 됨
		userservice.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);  //자바오브젝트를 JSON으로 변환해서 리턴(Jackson)
	}
	
	//전통 로그인
//	@PostMapping("/api/user/login")
//	public ResponseDto<Integer> login(@RequestBody User user){
//		System.out.println("UserApiController : login 호출됨" );
//		User principal = userservice.로그인(user); //principal(접근주체)
//		
//		if (principal != null) {
//			session.setAttribute("principal", principal);
//		}
//		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//	}
	
	//시큐리티 로그인
		
}