package com.neusoft.mapper;

import com.neusoft.entity.CheckItemRecord;
import com.neusoft.service.CheckitemRecordService;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CheckItemRecordMapper {
    public int insert(CheckItemRecord checkitemRecord);

    CheckItemRecord select(CheckItemRecord checkItemRecord);
}
