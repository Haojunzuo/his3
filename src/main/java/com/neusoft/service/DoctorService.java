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
    public List<Doctor> getDoctorData(){
        return doctorMapper.getDoctorData();
    }
    public Doctor getDoctorById(int doctorid){
        return doctorMapper.selectById(doctorid);
    }
    public List<Doctor> selectByDeptId(int deptid){
        return doctorMapper.selectByDeptId(deptid);
    }
}
