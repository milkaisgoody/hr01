package com.example.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hr.service.DeptService;

import lombok.RequiredArgsConstructor;

@Controller
// 필드주입 -> 생성자 주입
@RequiredArgsConstructor
public class DeptController {
	
	private final DeptService service;
	
	@GetMapping("/depts")
	public void depts(Model model) {
		
		model.addAttribute("totalCnt", service.totalCnt());
		model.addAttribute("list", service.selectAll());
	}
}
