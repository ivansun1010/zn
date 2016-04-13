package com.iat.zn.show.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Author: zhangxin
 * Date:   15-9-1
 */
@Aspect
@Component
public class AopMonitor {

    /*@AfterReturning("execution(* com.puhui.bestbuy.service.PersonService.*(..))")
    public void afterReturningAdvisor(JoinPoint joinPoint) {
        System.out.println("@@@@@Completed: " + joinPoint + "@@@@@");
    }*/
}
