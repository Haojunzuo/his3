package com.neusoft.controller;

import com.neusoft.entity.CheckItem;
import com.neusoft.entity.CheckItemRecord;
import com.neusoft.entity.CheckItemRecordList;
import com.neusoft.service.CheckItemService;
import com.neusoft.service.CheckitemRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Doctor/CheckItemController")
public class CheckItemController {
    @Autowired
    private CheckItemService checkItemService;
    @Autowired
    private CheckitemRecordService checkitemRecordService;

    @RequestMapping("/startCheckItem")
    public String startCheckItem(){
        return "doctor_checkitem";
    }
    @RequestMapping("/selectAll")
    @ResponseBody
    public List<CheckItem> selectAll(){
        return checkItemService.selectAll();
    }
    @ResponseBody
    @RequestMapping("/createCheckItemRecord")
    public String createCheckItemRecord(CheckItemRecordList cirList){
        if (cirList != null) {
            List<CheckItemRecord> list = cirList.getCirList();
            if(list!=null&&list.size()>0){
                for (CheckItemRecord c : list) {
//                    System.out.println(c.getAmount()+c.getPid()+c.getCid());
                    checkitemRecordService.insert(c);
                }
                return "yes";
            }
        }else{

        }
        return "no";
    }

}
