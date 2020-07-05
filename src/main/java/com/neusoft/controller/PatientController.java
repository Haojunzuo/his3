package com.neusoft.controller;

import com.neusoft.entity.Patient;
import com.neusoft.entity.User;
import com.neusoft.service.DeptService;
import com.neusoft.service.DoctorService;
import com.neusoft.service.LevelService;
import com.neusoft.service.PatientService;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/Patient/PatientController")//这里修改了，加上一个patient。
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private LevelService levelService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DeptService deptService;
    //这个方法都是使用老师给的百度网盘的视频的思路完成的，属于在前端进行判断等操作，老师这次讲得是直接将相关数据封装进入一个patient对象，问题都在后端解决了。
//    @RequestMapping("/selectPatients")
//    public String selectPatients1(Model model){
//        List<Patient> patients1 = patientService.selectPatients(0);
//        List<Patient> patients2 = patientService.selectPatients(1);
//        model.addAttribute("depts",deptService.getDeptData());
//        model.addAttribute("levels",levelService.getLevelData());
//        model.addAttribute("doctors",doctorService.getDoctorData());
//        model.addAttribute("patients1",patients1);
//        model.addAttribute("patients2",patients2);
//        return "doctor_medicalrecord";
//    }

    //门诊管理员的第一个页面（挂号）的入口
    @RequestMapping("/startPatient")
    public String startPatient(Model model){
        List<Patient> patients = patientService.getPatientData(1,2);
        model.addAttribute("patients",patients);
        return "/outpatient_register.html";
    }


    @ResponseBody
    @RequestMapping("/selectByPid")
    public Patient selectByPid(Integer pid){
        Patient p = patientService.selectByPid(pid);
        if(p==null){
            p = new Patient();
            p.setPid(-1);
        }
        return p;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String insert(Patient p, HttpSession session){
        User u = (User) session.getAttribute("user");
        System.out.println(p.getPname());
        System.out.println(p.getBirthday());
        if(u!=null){
            p.setOperator(u.getUserid());
            System.out.println(u.getRole());
            try {
                patientService.insert(p);
            } catch (Exception e) {
                return "no";
            }
            return "yes";
        }else{
            return "no";
        }
    }
    @RequestMapping("startRefundPatient")
    public String startRefundPatient(){

        return "/outpatient_refund.html";
    }
    @ResponseBody
    @RequestMapping("/selectAll")
    public List<Patient> selectAll()
    {
        return patientService.selectAll();
    }
    @ResponseBody
    @RequestMapping("/refund")
    public int refund(int pid){
        int ret = patientService.refund(pid);
        return patientService.refund(pid);
    }

    @ResponseBody
    @RequestMapping("/getPatientData")
//    public List<Patient> getPatientData(@RequestParam("pagenum") int pagenum,@RequestParam("pagesize") int pagesize){
        public List<Patient> getPatientData(int pagenum,int pagesize){
        return patientService.getPatientData(pagenum,pagesize);
    }
}
