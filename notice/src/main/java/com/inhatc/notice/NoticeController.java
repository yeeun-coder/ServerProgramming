package com.inhatc.notice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NoticeController {
	@GetMapping("/notice")
	@ResponseBody
	public String notice() {
		System.out.println("notice");
		return "notice";
	}
}
