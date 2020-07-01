package com.neusoft.mapper;

import com.neusoft.entity.Level;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LevelMapper {
    public List<Level> selectAll();
    public Level selectById(int id);
}
