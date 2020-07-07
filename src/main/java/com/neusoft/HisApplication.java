package com.neusoft;

import com.neusoft.Interceptor.DoctorInterceptor;
import com.neusoft.Interceptor.PatientInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableTransactionManagement
public class HisApplication implements WebMvcConfigurer {

    @Autowired
    private PatientInterceptor patientInterceptor;
    @Autowired
    private DoctorInterceptor doctorInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(patientInterceptor).excludePathPatterns("/Patient/PatientController/selectByPid");
        registry.addInterceptor(patientInterceptor).addPathPatterns("/Patient/**").excludePathPatterns("/Patient/PatientController/selectByPid1");

        registry.addInterceptor(doctorInterceptor).addPathPatterns("/Doctor/**").excludePathPatterns("/Doctor/DoctorController/selectByDeptId");

    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("classpath:/resources/");
//        registry.addResourceHandler("classpath:/img/");
//        registry.addResourceHandler("classpath:/js/");
//        registry.addResourceHandler("classpath:/css/");
//    }

    public static void main(String[] args) {
        SpringApplication.run(HisApplication.class, args);
    }
}
