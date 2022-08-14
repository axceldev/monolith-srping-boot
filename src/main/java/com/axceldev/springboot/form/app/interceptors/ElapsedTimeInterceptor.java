package com.axceldev.springboot.form.app.interceptors;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("elapsedTimeInterceptor")
public class ElapsedTimeInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(ElapsedTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    throws Exception {

        if (request.getMethod().equalsIgnoreCase("post")) {
            return true;
        }
        
        if(handler instanceof HandlerMethod){
            HandlerMethod method = (HandlerMethod) handler;
            log.info("Es un metodo del controlador " + method.getMethod().getName());
        }
            
        log.info("[ElapsedTimeInterceptor]: preHandle() Entrando...");
        log.info("[Interceptando]: " + handler);
        long initialTime = System.currentTimeMillis();
        request.setAttribute("initialTime", initialTime);
        Random random = new Random();
        Integer delay = random.nextInt(100);
        Thread.sleep(delay);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
                
        if (!request.getMethod().equalsIgnoreCase("post")) {
            long finalTime = System.currentTimeMillis();
            long initialTime = (Long) request.getAttribute("initialTime");
            long elapsedTime = finalTime - initialTime;

            if(handler instanceof HandlerMethod && modelAndView !=null)
                modelAndView.addObject("elapsedTime", elapsedTime);    
            log.info("Tiempo transcurrido de la vista:" + elapsedTime + "milisegundos.");
            log.info("[ElapsedTimeInterceptor]: postHandle() Saliendo...");
        }
    }

}
