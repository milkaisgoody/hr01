package com.example.hr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hr.dto.DeptDto;
import com.example.hr.mapper.DeptMapper;

@Service
public class DeptServiceImpl implements DeptService {

	private final DeptMapper mapper;
	
	public DeptServiceImpl(DeptMapper mapper) {
		super();
		this.mapper = mapper;
	}

	@Override
	public int totalCnt() {
		return mapper.totalCnt();
	}

	@Override
	public List<DeptDto> selectAll() {
		return mapper.selectAll();
	}

}
