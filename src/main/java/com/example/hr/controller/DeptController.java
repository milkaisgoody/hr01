package com.example.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.hr.dto.DeptDto;
import com.example.hr.service.DeptService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
// 필드주입 -> 생성자 주입
@RequiredArgsConstructor
@Slf4j
public class DeptController {
	
	private final DeptService service;
	
	@GetMapping("/depts")
	public void depts(Model model) {
		model.addAttribute("totalCnt", service.totalCnt());
		model.addAttribute("list", service.selectAll());
	}
	
	/*
	 * 부서 등록 -> 리스트 페이지 -> 메세지 출력
	 */
	@PostMapping("/saveDept")
	public String depts(@ModelAttribute DeptDto dept, Model model) {
		log.info("dept : " + dept);
		// 데이터베이스에 저장
		try {
			int res = service.saveDept(dept);	
			if(res>0)
				model.addAttribute("msg", "등록 되었습니다.");
			else 
				model.addAttribute("error", "등록 실패");
		} catch (Exception e) {
			
			//model.addAttribute("error", e.getMessage());
			model.addAttribute("error", "등록 실패 되었습니다.");
		}
		
		
		
		// 요청 -> 화면
		// 요청/saveDept -> 다른 요청/depts
		// forward, redirect
		
		// 리스트가 안보이는 이유?
		// -> 모델에 저장을 안해서
		
		model.addAttribute("list", service.selectAll());
		
		return "depts";
	}
}
