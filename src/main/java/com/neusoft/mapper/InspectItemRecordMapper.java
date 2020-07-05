package com.neusoft.mapper;

import com.neusoft.entity.InspectItemRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InspectItemRecordMapper {
    public int insert(InspectItemRecord inspectItemRecord);

    InspectItemRecord select(InspectItemRecord inspectItemRecord);
}
