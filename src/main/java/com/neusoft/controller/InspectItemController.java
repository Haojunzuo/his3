package com.neusoft.controller;

import com.neusoft.entity.*;
import com.neusoft.service.InspectItemService;
import com.neusoft.service.InspectItemRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Doctor/InspectItemController")
public class InspectItemController {
    @Autowired
    private InspectItemService inspectItemService;
    @Autowired
    private InspectItemRecordService inspectItemRecordService;
    @RequestMapping("/startInspectItem")
    public String startInspectItem(){
        return "/doctor_inspectitem";
    }
    @ResponseBody
    @RequestMapping("/selectAll")
    public List<InspectItem> selectAll(){
        return inspectItemService.selectAll();
    }
    @ResponseBody
    @RequestMapping("/createInspectItemRecord")
    public String createInspectItemRecord(InspectItemRecordList iirList){
        if(iirList!=null){
            List<InspectItemRecord> list = iirList.getIirList();
            if(list!=null&&list.size()>0){
                for (InspectItemRecord iir : list) {
//                    System.out.println(iir.getAmount());
                    inspectItemRecordService.insert(iir);
                }
                return "yes";
            }
        }
        return "no";
    }

}
