package com.neusoft.entity;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MedicalRecord {
    private Integer id;
    private Integer pid;
    private String description;
    private String medicalhistory;
    private String familyhistory;
    private String initialresult;
    private String result;
    private String finalresult;
    private Integer status;
    private Integer operator;
    private String operatedate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMedicalhistory() {
        return medicalhistory;
    }

    public void setMedicalhistory(String mdeicalhistory) {
        this.medicalhistory = mdeicalhistory;
    }

    public String getFamilyhistory() {
        return familyhistory;
    }

    public void setFamilyhistory(String familyhistory) {
        this.familyhistory = familyhistory;
    }

    public String getInitialresult() {
        return initialresult;
    }

    public void setInitialresult(String initialresult) {
        this.initialresult = initialresult;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getFinalresult() {
        return finalresult;
    }

    public void setFinalresult(String finalresult) {
        this.finalresult = finalresult;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public String getOperatedate() {
        return operatedate;
    }

    public void setOperatedate(Date operatedate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = simpleDateFormat.format(operatedate);
        this.operatedate = dateString;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "id=" + id +
                ", pid=" + pid +
                ", description='" + description + '\'' +
                ", medicalhistory='" + medicalhistory + '\'' +
                ", familyhistory='" + familyhistory + '\'' +
                ", initialresult='" + initialresult + '\'' +
                ", result='" + result + '\'' +
                ", finalresult='" + finalresult + '\'' +
                ", status=" + status +
                ", operator=" + operator +
                ", operatedate=" + operatedate +
                '}';
    }
}
