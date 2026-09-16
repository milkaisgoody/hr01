package com.example.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.hr.dto.DeptDto;

@Mapper
public interface DeptMapper {
	
	@Select("select count(*) from dept")
	public int totalCnt();
	
	public List<DeptDto> selectAll();
	
	@Insert("INSERT INTO DEPT VALUES (#{deptId}, #{deptTitle}, #{locationId})")
	public int saveDept(DeptDto dept);
}
