package com.neusoft.controller;

import com.neusoft.entity.Doctor;
import com.neusoft.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Doctor/DoctorController")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @ResponseBody
    @RequestMapping("/selectByDeptId")
    public List<Doctor> selectByDeptId(int deptid){
        return doctorService.selectByDeptId(deptid);
    }
}
