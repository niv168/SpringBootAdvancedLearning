package com.Week1.aopApp.aspects;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution (* com.Week1.aopApp.services.impl.*.* (..))")  //defines pointcut
    public void beforeOrderPackage(JoinPoint joinPoint){
        log.info("Before being called from logging aspect signature, {}",joinPoint.getSignature());
        log.info("Before being called from logging aspect kind, {}",joinPoint.getKind());
       // log.info("Before being called from logging aspect, {}",joinPoint.getSignature());
    }

    @Before("within(com.Week1.aopApp.services.impl.*)")
    public void beforeServiceImplCalls(){
        log.info("service impl calls");
    }

    @Before("myPointcut()")
    public void beforeTransactionalCalls(){
        log.info("before transactional calls");
    }

    @Pointcut("@annotation(com.Week1.aopApp.aspects.MyLogging)")
    public void myPointcut(){

    }
}
