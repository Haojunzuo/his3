package com.neusoft.Interceptor;

import com.neusoft.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class DoctorInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User)request.getSession().getAttribute("user");
        if(null==user){
            request.setAttribute("message","对不起，您还没有登录！");
            response.sendRedirect(request.getContextPath()+"/login.html");
            return false;

        }else{
            System.out.println(user.getRole()+user.getUsername());
            if(user.getRole().equals("医生管理员")){
                return true;
            }else{
                System.out.println("false");
                response.sendRedirect(request.getContextPath()+"/login.html");
                return false;
            }
        }
    }

//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        User user = (User)request.getSession().getAttribute("user");
//        if(null==user){
//            String message = "对不起，您还没有登录！";
//            modelAndView.addObject("message",message);
//            modelAndView.setViewName("/login.html");
//            return modelAndView;
//        }
//    }
}
