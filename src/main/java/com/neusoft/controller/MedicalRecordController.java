package com.neusoft.controller;

import com.neusoft.entity.Doctor;
import com.neusoft.entity.MedicalRecord;
import com.neusoft.entity.Patient;
import com.neusoft.entity.User;
import com.neusoft.service.DoctorService;
import com.neusoft.service.MedicalRecordService;
import com.neusoft.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.zip.CheckedOutputStream;

@Controller
@RequestMapping("/Doctor/MedicalRecordController")
public class MedicalRecordController {
    @Autowired
    private MedicalRecordService medicalRecordService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;
    @ResponseBody
    @RequestMapping("/getMedicalRecordById")
    public MedicalRecord getMedicalRecordById(int pid){
        return medicalRecordService.getMedicalRecordById(pid);
    }
    @ResponseBody
    @RequestMapping("/update")
    public int update(String result,String finalresult,int pid){
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setResult(result);
        medicalRecord.setFinalresult(finalresult);
        medicalRecord.setPid(pid);
        System.out.println(medicalRecord.getPid());
        System.out.println(medicalRecord.getResult());
        System.out.println(medicalRecord.getFinalresult());
        return medicalRecordService.update(medicalRecord);
    }

    @RequestMapping("/startMedicalRecord")
    public String startMedicalRecord(HttpSession session,
                                     Model model){
        User user = (User) session.getAttribute("user");
        String name = "";
        if(user!=null&&"医生管理员".equals(user.getRole())){//这里用了良好的编程习惯，避免了为空报错的现象出现。
            name = user.getUsername();
//            int id = -1;
//            Doctor doctor = doctorService.selectByDname(name);
//            id = doctor.getId();
            List<Patient> patients1 = patientService.select1(name);
            List<Patient> patients2 = patientService.select2(name);
            model.addAttribute("patients1",patients1);
            model.addAttribute("patients2",patients2);
        }
        return "doctor_medicalrecord";
    }
}
