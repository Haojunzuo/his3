package com.neusoft.entity;

public class Doctor {
    private Integer id;
    private String dname;
    private Integer deptid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", dname='" + dname + '\'' +
                ", deptid=" + deptid +
                '}';
    }
}
