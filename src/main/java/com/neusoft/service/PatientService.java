package com.neusoft.service;

import com.neusoft.entity.Patient;
import com.neusoft.mapper.PatientMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PatientService {
    @Resource
    private PatientMapper patientMapper;
    public List<Patient> selectPatients(Integer status){
        return patientMapper.selectPatients(status);
    }
    public Patient selectPatientById(Integer pid){
        return patientMapper.selectPatientById(pid);
    }
    public void refundPatient(Integer pid){
        patientMapper.refundPatient(pid);
    }
    public int insert(Patient patient){
        return patientMapper.insert(patient);
    }
    public Patient selectByPid(int pid){
        return patientMapper.selectByPid(pid);
    }
    public List<Patient> selectAll(){
        return patientMapper.selectAll();
    }
    public int refund(int id){
        return patientMapper.refund(id);
    }
}