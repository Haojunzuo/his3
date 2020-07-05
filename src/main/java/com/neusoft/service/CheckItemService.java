package com.neusoft.service;

import com.neusoft.entity.CheckItem;
import com.neusoft.mapper.CheckItemMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CheckItemService {
    @Resource
    private CheckItemMapper checkItemMapper;
    public List<CheckItem> selectAll() {
        return checkItemMapper.selectAll();
    }
}
