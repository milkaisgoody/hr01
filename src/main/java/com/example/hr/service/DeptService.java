package com.example.hr.service;

import java.util.List;

import com.example.hr.dto.DeptDto;

public interface DeptService {
	
	public int totalCnt();
	
	public List<DeptDto> selectAll();
	
}
