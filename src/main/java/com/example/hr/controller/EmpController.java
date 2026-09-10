package com.example.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hr.service.EmpService;


@Controller
public class EmpController {

	@Autowired
	private EmpService service;
	
	// 여러개의 주소를 매핑
	@GetMapping({"/", "/emps"})
	public String getMethodName(Model model) {
		
		//model.addAttribute("totalCnt", service.totalCnt());
		service.selectByCond(model);
		return "/index";
	}
	
}
