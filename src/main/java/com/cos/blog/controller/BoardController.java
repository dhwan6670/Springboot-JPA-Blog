package com.cos.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	@GetMapping({"","/"})
	public String index() {
		return "index"; //application.yml로 인해 /WEB-INF/views/index.jsp로 이동
	}
}
