package com.neusoft.controller;

import com.neusoft.entity.Level;
import com.neusoft.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/LevelController")
public class LevelController {
    @Autowired
    private LevelService levelService;

    @ResponseBody
    @RequestMapping("/getLevelById")
    public Level getLevelById(@RequestParam("levelid") String levelid){
        return levelService.getLevelById(Integer.parseInt(levelid));
    }
    @ResponseBody
    @RequestMapping("/selectAll")
    public List<Level> selectAll()
    {
        return levelService.selectAll();
    }
}
