package com.neusoft.service;

import com.neusoft.entity.CheckItemRecord;
import com.neusoft.mapper.CheckItemRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CheckitemRecordService {
    @Resource
    private CheckItemRecordMapper checkItemRecordMapper;
    public int insert(CheckItemRecord checkItemRecord){
        int row = 0;
        if(checkItemRecordMapper.select(checkItemRecord)==null) {
            row =  checkItemRecordMapper.insert(checkItemRecord);
        }
        return row;
    }

}
