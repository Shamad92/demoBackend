package com.task.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class IPAddressInterceptor implements HandlerInterceptor {
 
	private Logger logger = LoggerFactory.getLogger(IPAddressInterceptor.class);
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
 
        String ipAddress = request.getHeader("X-Forward-For");

        if(ipAddress == null){
            ipAddress = request.getRemoteAddr();
        }
        
        logger.info("Request from IP: "+ipAddress);
        
        String headerName = request.getHeader("X-Application");

        if(headerName == null) {
        	return true;
        }
        
        if(headerName.equals("Test")) {
            return true;
        }
        else {
            return false;
        }
    }
}