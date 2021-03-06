package com.neusoft.mapper;

import com.neusoft.entity.Patient;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PatientMapper {
    public List<Patient> selectPatients(Integer status);
    public int insert(Patient patient);
    public Patient selectByPid(Integer id);
    public List<Patient> selectAll();
    public int refund(int id);
    public List<Patient> select1(String dname);
    public List<Patient> select2(String dname);

    int updateStatus(Integer pid);

    List<Patient> getPatientData(int index, int pagesize);

}
