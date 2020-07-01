package com.neusoft.service;

import com.neusoft.entity.MedicalRecord;
import com.neusoft.mapper.MedicalRecordMapper;
import com.sun.glass.ui.delegate.MenuItemDelegate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MedicalRecordService {
    @Resource
    private MedicalRecordMapper medicalRecordMapper;
    public MedicalRecord getMedicalRecordById(int pid){
        return medicalRecordMapper.getMedicalRecordById(pid);
    }
    public int update(MedicalRecord medicalRecord){
        return medicalRecordMapper.update(medicalRecord);
    }
}
