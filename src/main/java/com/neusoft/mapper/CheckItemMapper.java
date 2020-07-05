package com.neusoft.mapper;

import com.neusoft.entity.CheckItemRecord;
import com.neusoft.entity.CheckItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CheckItemMapper {
    List<CheckItem> selectAll();
    CheckItem selectById(int id);
}
