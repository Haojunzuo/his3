package com.neusoft.service;

import com.neusoft.entity.Doctor;
import com.neusoft.mapper.DoctorMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DoctorService {
    @Resource
    private DoctorMapper doctorMapper;
    public List<Doctor> selectByDeptId(int deptid){
        return doctorMapper.selectByDeptId(deptid);
    }
    public Doctor selectByDname(String dname){
        return doctorMapper.selectByDname(dname);
    }
}
