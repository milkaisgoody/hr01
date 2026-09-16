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
		System.out.println(list);
		
		assertEquals(9, list.size());
		
	}
	
	@Test
	public void saveDept() {
		DeptDto dto = new DeptDto();
		dto.setDeptId("A3");
		dto.setDeptTitle("신규사업부");
		dto.setLocationId("L2");
		
		int res = mapper.saveDept(dto);
		assertEquals(1, res);
		
		if(res > 0) {
			System.out.println("등록 되었습니다.");
		} else {
			System.out.println("등록 실패");
		}
		
		
	}
}









