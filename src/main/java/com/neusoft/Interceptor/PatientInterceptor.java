package com.neusoft.Interceptor;

import com.neusoft.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class PatientInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User)request.getSession().getAttribute("user");
        if(null==user){
            response.sendRedirect(request.getContextPath()+"/login.html");
            return false;
        }else{
            System.out.println(user.getRole()+user.getUsername());
            if(user.getRole().equals("门诊管理员")){
                return true;
            }else{
                System.out.println("false");
                response.sendRedirect(request.getContextPath()+"/login.html");
                return false;
            }
        }
    }
}
