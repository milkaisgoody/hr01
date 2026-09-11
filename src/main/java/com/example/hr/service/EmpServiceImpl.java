package com.example.hr.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.hr.dto.EmpDto;
import com.example.hr.mapper.EmpMapper;

/*
 * 인터페이스의 구현체 
 */
@Service
public class EmpServiceImpl implements EmpService {

	// @Autowired : 필드 주입
	// 리플렉션으로 필드에 직접 주입
	
	// DI
	// 1. 필드 주입
	// 2. Setter 주입
	// 3. 생성자 주입
	// @Autowired
	private final EmpMapper mapper;

	public EmpServiceImpl(EmpMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public int totalCnt() {
		
		return mapper.totalCnt();
	}

	@Override
	public void selectByCond(Model model) {
		List<EmpDto> list = mapper.selectByCond();
		int totalCnt = mapper.totalCnt();
		
		model.addAttribute("list", list);
		model.addAttribute("totalCnt", totalCnt);
	}

	@Override
	public EmpDto selectById(String empId) {
		return mapper.selectById(empId);
	}

}
