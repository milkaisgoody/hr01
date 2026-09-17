package com.example.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@GetMapping("/login")
	public void login() {
		
	}
	
	// /login -> post방식으로 요청
	// id,pw수집
	// 로그인 -> 회원목록페이지로 이동
	@PostMapping("/login")
	public String loginAction(@RequestParam(name = "id") String id,
								@RequestParam(name = "pw") String pw) {
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		
		/*  1. 아이디 비밀번호 검증
		 		입력된 아이디로 사용자 조회
		 		
		 		비밀번호가 일치하면 로그인 성공 -> 세션에 사용자 정보 저장 -> 사원목록
		 	
		 	    비밀번호가 불일치시 로그인 실패  
		 			-> login_fail_count 업데이트 (5회 초과 실패시 계정 잠금)
		 			-> 메세지 처리
		 			-> 뒤로가기
		*/ 
		
		
		return "redirect:emps";
	}
}
