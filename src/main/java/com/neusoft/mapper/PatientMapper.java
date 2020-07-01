package com.neusoft.mapper;

import com.neusoft.entity.Patient;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PatientMapper {
    public List<Patient> selectPatients(Integer status);
    public Patient selectPatientById(Integer pid);
    public void refundPatient(Integer id);
    public int insert(Patient patient);
    public Patient selectByPid(Integer id);
    public List<Patient> selectAll();
    public int refund(int id);
}
