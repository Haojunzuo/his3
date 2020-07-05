package com.neusoft.controller;

import com.neusoft.entity.CheckItemRecord;
import com.neusoft.entity.CheckItemRecordList;
import com.neusoft.entity.InspectItemRecordList;
import com.neusoft.service.CheckitemRecordService;
import com.neusoft.service.InspectItemRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/PayController")
public class PayController {

    @Autowired
    private CheckitemRecordService checkitemRecordService;

    @Autowired
    private InspectItemRecordService inspectItemRecordService;
    @RequestMapping("/startPay")
    public String startPay(){
        return "/outpatient_pay";
    }

    @RequestMapping("/doPay")
    @ResponseBody
    public String dopay(HttpServletRequest request){
        String info = "no";
        String[] cids = request.getParameterValues("cid");
        String[] iids = request.getParameterValues("iid");
        try {
            if (cids!=null&&cids.length!=0) {
                for (int i=0; i<cids.length; i++){
                    checkitemRecordService.updatePayStatus(Integer.parseInt(cids[i]));
                    System.out.println(cids[i]);
                }
            }
            if (iids!=null&&iids.length!=0) {
                for (int j=0; j<iids.length; j++){
                    inspectItemRecordService.updatePayStatus(Integer.parseInt(iids[j]));
                    System.out.println(iids[j]);
                }
            }
            return "yes";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "no";
    }
}
