package com.neusoft.service;

import com.neusoft.entity.MedicalRecord;
import com.neusoft.mapper.MedicalRecordMapper;
import com.neusoft.mapper.PatientMapper;
import com.sun.glass.ui.delegate.MenuItemDelegate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MedicalRecordService {
    @Resource
    private MedicalRecordMapper medicalRecordMapper;
    @Resource
    private PatientMapper patientMapper;
    public int update(MedicalRecord medicalRecord){
        return medicalRecordMapper.update(medicalRecord);
    }

    public String createMedicalRecord(MedicalRecord mr) {
        String info = "no";
        MedicalRecord m = medicalRecordMapper.selectByPid(mr.getPid());
        if(m==null){
            int row = medicalRecordMapper.insert(mr);
            int row2 = patientMapper.updateStatus(mr.getPid());
            if(row==1&&row2==1){
                info = "yes";
            }
        }
        return info;
    }
}
