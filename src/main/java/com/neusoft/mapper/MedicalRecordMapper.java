package com.neusoft.mapper;

import com.neusoft.entity.MedicalRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MedicalRecordMapper {
    public MedicalRecord getMedicalRecordById(int pid);
    public int update(MedicalRecord medicalRecord);
}
