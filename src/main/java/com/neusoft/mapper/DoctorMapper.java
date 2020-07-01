package com.neusoft.mapper;

import com.neusoft.entity.Doctor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DoctorMapper {
    public Doctor selectById(int id);
    public List<Doctor> selectByDeptId(int deptid);
    public Doctor selectByDname(String dname);
}
