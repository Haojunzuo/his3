package com.neusoft.mapper;

import com.neusoft.entity.InspectItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InspectItemMapper {

    List<InspectItem> selectAll();
}
