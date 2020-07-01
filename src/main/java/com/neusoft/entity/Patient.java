package com.neusoft.entity;

import java.text.SimpleDateFormat;
import java.sql.Date;

public class Patient {
    private int pid;
    private String pname;
    private String sex;
    private int age;
    private Date birthday;
    private String idcard;
    private String address;
    private int levelid;
    private int deptid;
    private int doctorid;
    private Date createDate;
    private int cost;
    private String pstatus;
    private int status;
    private int operator;
    private Date operateDate;

    private Dept dept;
    private Doctor doc;
    private Level level;
    private MedicalRecord medicalRecord;

    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Doctor getDoc() {
        return doc;
    }

    public void setDoc(Doctor doc) {
        this.doc = doc;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    //    private int pid;
//    private String pname;
//    private String sex;
//    private int age;
//    private java.sql.Date birthday;
//    private String idcard;
//    private String address;
//    private int levelid;
//    private int deptid;
//    private int doctorid;
//    private java.sql.Date createDate;
//    private int cost;
//    private String pstatus;
//    private int status;
//    private int operator;
//    private java.sql.Date operateDate;
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLevelid() {
        return levelid;
    }

    public void setLevelid(int levelid) {
        this.levelid = levelid;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public int getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(int doctorid) {
        this.doctorid = doctorid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getPstatus() {
        return pstatus;
    }

    public void setPstatus(String pstatus) {
        this.pstatus = pstatus;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }


    @Override
    public String toString() {
        return "Patient{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", idcard='" + idcard + '\'' +
                ", address='" + address + '\'' +
                ", levelid=" + levelid +
                ", deptid=" + deptid +
                ", doctorid=" + doctorid +
                ", createDate=" + createDate +
                ", cost=" + cost +
                ", pstatus='" + pstatus + '\'' +
                ", status=" + status +
                ", operator=" + operator +
                ", operateDate=" + operateDate +
                '}';
    }
}