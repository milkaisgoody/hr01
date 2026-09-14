package com.example.hr.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.hr.dto.DeptDto;

// 클래스의 선언부
@SpringBootTest
public class DeptMapperTest {
	
	@Autowired
	DeptMapper mapper;
	
	@Test
	public void totalCnt() {
		int res = mapper.totalCnt();
		// 검증
		assertEquals(9, res);
	}
	
	@Test
	public void selectAll() {
		List<DeptDto> list = mapper.selectAll();
		assertEquals(9, list.size());
		
	}
}
