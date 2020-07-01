package com.neusoft.service;

import com.neusoft.entity.Level;
import com.neusoft.mapper.LevelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LevelService {
    @Resource
    private LevelMapper levelMapper;
    public List<Level> getLevelData(){
        return levelMapper.getLevelData();
    }
    public Level getLevelById(int levelid){
        return levelMapper.selectById(levelid);
    }
}
