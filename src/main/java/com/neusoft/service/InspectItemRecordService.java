package com.neusoft.service;

import com.neusoft.entity.InspectItemRecord;
import com.neusoft.mapper.InspectItemRecordMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class InspectItemRecordService {
    @Resource
    private InspectItemRecordMapper inspectItemRecordMapper;
    public int insert(InspectItemRecord inspectItemRecord){
        int row = 0;
        if(inspectItemRecordMapper.select(inspectItemRecord)==null) {
            row =  inspectItemRecordMapper.insert(inspectItemRecord);
        }
        return row;
    }
    public int updatePayStatus(int id){
        return inspectItemRecordMapper.updatePayStatus(id);
    }

}
