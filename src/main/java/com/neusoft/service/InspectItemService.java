package com.neusoft.service;

import com.neusoft.entity.InspectItem;
import com.neusoft.mapper.InspectItemMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InspectItemService {
    @Resource
    private InspectItemMapper inspectItemMapper;
    public List<InspectItem> selectAll() {
        return inspectItemMapper.selectAll();
    }
}
