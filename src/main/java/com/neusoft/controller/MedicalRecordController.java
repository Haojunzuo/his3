package com.neusoft.controller;

import com.neusoft.entity.MedicalRecord;
import com.neusoft.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/MedicalRecordController")
public class MedicalRecordController {
    @Autowired
    private MedicalRecordService medicalRecordService;

    @ResponseBody
    @RequestMapping("/getMedicalRecordById")
    public MedicalRecord getMedicalRecordById(int pid){
        return medicalRecordService.getMedicalRecordById(pid);
    }
    @ResponseBody
    @RequestMapping("/update")
    public int update(String result,String finalresult,int pid){
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setResult(result);
        medicalRecord.setFinalresult(finalresult);
        medicalRecord.setPid(pid);
        System.out.println(medicalRecord.getPid());
        System.out.println(medicalRecord.getResult());
        System.out.println(medicalRecord.getFinalresult());
        return medicalRecordService.update(medicalRecord);
    }
}
