package com.neusoft.mapper;

import com.neusoft.entity.InspectItemRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InspectItemRecordMapper {
    public int insert(InspectItemRecord inspectItemRecord);

    InspectItemRecord select(InspectItemRecord inspectItemRecord);
    List<InspectItemRecord> selectByPid(int pid);
    int updatePayStatus(int id);
}
