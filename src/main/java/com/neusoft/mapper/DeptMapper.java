package com.neusoft.mapper;

import com.neusoft.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {
    public List<Dept> selectAll();
    public Dept selectById(int deptid);
}
