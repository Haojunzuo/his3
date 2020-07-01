package com.neusoft.service;

import com.neusoft.entity.Dept;
import com.neusoft.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptService {
    @Resource
    private DeptMapper deptMapper;
    public List<Dept>getDeptData(){
        return deptMapper.getDeptData();
    }
    public Dept getDeptById(int deptid){
        return deptMapper.selectById(deptid);
    }
}
