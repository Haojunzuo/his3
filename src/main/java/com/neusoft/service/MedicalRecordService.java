package com.neusoft.service;

import com.neusoft.entity.MedicalRecord;
import com.neusoft.mapper.MedicalRecordMapper;
import com.neusoft.mapper.PatientMapper;
import com.sun.glass.ui.delegate.MenuItemDelegate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;

@Service
public class MedicalRecordService {
    @Resource
    private MedicalRecordMapper medicalRecordMapper;
    @Resource
    private PatientMapper patientMapper;

    public int update(MedicalRecord medicalRecord) {
        return medicalRecordMapper.update(medicalRecord);
    }

//    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
//    @Transactional
//    public String createMedicalRecord(MedicalRecord mr) {
//        String info = "no";
//        MedicalRecord m = medicalRecordMapper.selectByPid(mr.getPid());
//        if (m == null) {
//            try {
//                int row = medicalRecordMapper.insert(mr);
//                System.out.println("insert");
//                int i = 1/0;
//                int row2 = patientMapper.updateStatus(mr.getPid());
//                System.out.println("update");
//                if (row == 1 && row2 == 1) {
//                    info = "yes";
//                }
//            } catch (Exception e) {
////                e.printStackTrace();
//
//            }
//        }
//        return info;
//    }


    @Transactional
    public String createMedicalRecord(MedicalRecord mr) {
        String info = "no";
        MedicalRecord m = medicalRecordMapper.selectByPid(mr.getPid());
        if (m==null){
            try {
                int row = medicalRecordMapper.insert(mr);
                System.out.println("do insert");
                int i = 1 / 0;
                int row2 = patientMapper.updateStatus(mr.getPid());
                System.out.println("update");
                if (row == 1 && row2 == 1) {
                    info = "yes";
                }
                //默认spring事务只在发生未被捕获的 RuntimeException 时才回滚。
                //spring aop  异常捕获原理：被拦截的方法需显式抛出异常，并不能经任何处理，这样aop代理才能捕获到方法的异常，才能进行回滚，
                // 默认情况下aop只捕获 RuntimeException 的异常，但可以通过配置来捕获特定的异常并回滚。
                //使用spring的事务管理之后，可以直接在函数上抛出异常，不能使用catch 以下两种情况例外：在catch中抛出异常，手动处理异常，
        } catch (Exception throwable) {//这里的catch括号中的内容的类型并不影响，随便即可，不是这件问题的原因。
                System.out.println("try执行异常");
//                throwable.printStackTrace();
                System.out.println("打印之后");
                throw new RuntimeException(throwable);//把异常抛给了上层，上层的catch分支将处理异常，但是下面的return不能正常执行了
                //手动回滚之后，上层无需处理异常，即使上层写了异常捕获处理，也捕获不到异常，并且下面的return可以正常执行，上层的catch也就不会执行了，
                // 因此，不需要进行异常处理时，这一句代码就够了。
//                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
        return info;
    }
}
