package com.neusoft.mapper;

import com.neusoft.entity.Doctor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DoctorMapper {
    public List<Doctor> getDoctorData();
    public Doctor selectById(int doctorid);
    public List<Doctor> selectByDeptId(int deptid);
}
