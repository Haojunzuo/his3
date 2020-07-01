package com.neusoft.controller;

import com.neusoft.entity.Dept;
import com.neusoft.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/DeptController")
public class DeptController {
    @Autowired
    private DeptService deptService;
    @ResponseBody
    @RequestMapping("/getDeptById")
    public Dept getDeptById(@RequestParam("deptid") String deptid){
        return deptService.getDeptById(Integer.parseInt(deptid));
    }
    @ResponseBody
    @RequestMapping("/selectAll")
    public List<Dept> selectAll(){
        return deptService.getDeptData();
    }
}
