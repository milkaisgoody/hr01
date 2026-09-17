package com.example.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.hr.dto.DeptDto;
import com.example.hr.service.DeptService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
// 필드주입 -> 생성자 주입
@RequiredArgsConstructor
@Slf4j
public class DeptController {
	
	private final DeptService service;
	
	@GetMapping("/depts")
	public void depts(Model model, HttpSession session) {
		session.setAttribute("loginId", "abc");
		model.addAttribute("totalCnt", service.totalCnt());
		model.addAttribute("list", service.selectAll());
	}
	
	/*
	 * 부서 등록 -> 리스트 페이지 -> 메세지 출력
	 */
	@PostMapping("/saveDept")
	public String depts(@ModelAttribute DeptDto dept, RedirectAttributes ra) {
		// RedirectAttributes : redirect시 데이터를 유지하기 위해서 
		
		
		
		log.info("dept : " + dept);
		// 데이터베이스에 저장
		try {
			int res = service.saveDept(dept);	
			if(res>0) {
				//model.addAttribute("msg", "등록 되었습니다.");
				ra.addFlashAttribute("msg", "등록 되었습니다.");
			} else { 
				//model.addAttribute("error", "등록 실패");
				ra.addFlashAttribute("error", "등록 실패");
			}
		} catch (Exception e) {
			
			//model.addAttribute("error", e.getMessage());
			ra.addFlashAttribute("error", "등록 실패 되었습니다.");
			//model.addAttribute("error", "등록 실패 되었습니다.");
		}
		
		
		
		// 요청 -> 화면 (model)
		// 요청 /saveDept -> 다른 요청/depts 
		// forward(method가 일치해야지만 사용가능)
		// redirect : 2번 요청이 발생하므로 model에 데이터를 넣어도 유지가 되지 않는다
		//	(redirect시 데이터는 model에 저장하면 유지가 안됨!!! RedirectAttributes를 사용 해야한다.)
		
		// 리스트가 안보이는 이유?
		// -> 모델에 저장을 안해서
		
		// 부서 목록 페이지로 리다이렉트(웹브라우저에게 다시 요청하라고 전달)
		//model.addAttribute("list", service.selectAll());
		
		return "redirect:/depts";
	}
	
	// queryString -> PathVariable
	// queryString : /deletedept?deptId=A1 
	// PathVariable : /deletedept/A1
	// 경로로 부터 데이터를 수집
	@GetMapping("/deleteDept/{deptId}")
	public String deleteDept(@PathVariable(name = "deptId") String deptId) {
		log.info(deptId);
		System.out.println(deptId);
		return "redirect:/depts";
	}
}
