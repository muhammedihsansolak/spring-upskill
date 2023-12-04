package com.cydeo.aspect;

import com.cydeo.dto.CourseDTO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

//@Slf4j
@Aspect
@Component
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(LoggingAspect.class); //-> @Slf4j

//    @Pointcut("execution(* com.cydeo.controller.CourseController.*(..))")
//    public void myPointcut(){}
//
//    @Before("myPointcut()")
//    public void logs(){
//        logger.info("Info log........");
//    }
//
//    @Before("execution(* com.cydeo.controller.CourseController.*(..))")
//    public void log(){
//        logger.info("Info log........");
//    }
//
//    @Pointcut("execution(* com.cydeo.repository.CourseRepository.findById(*))")
//    public void courseReposFindByIdPC(){}
//
//    @Before("courseReposFindByIdPC()")
//    public void beforeCourseReposFindById(JoinPoint joinPoint){
//        logger.info(
//                "Before -> Method: {}, Arguments: {}, Target: {}",
//                joinPoint.getSignature(),
//                joinPoint.getArgs(),
//                joinPoint.getTarget()
//        );
//    }
//
//    @Pointcut("within(com.cydeo.controller..*)")
//    public void anyControllerOperation() {}
//
//    @Pointcut("@within(org.springframework.stereotype.Service)")
//    public void anyServiceOperation() {}
//
//    @Before("anyControllerOperation() || anyServiceOperation() ")
//    public void beforeControllerOrServiceAdvice(JoinPoint joinPoint) {
//        logger.info(
//                "Before -> Method: {}, Arguments: {}, Target: {}",
//                joinPoint.getSignature(),
//                joinPoint.getArgs(),
//                joinPoint.getTarget()
//        );
//    }
//
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
//    public void anyDeleteControllerOperation() {}
//
//    @Before("anyDeleteControllerOperation()")
//        public void beforeDeleteMappingAnnotation(JoinPoint joinPoint) {
//        logger.info(
//                "Before -> Method: {}, Arguments: {}, Target: {}",
//                joinPoint.getSignature(),
//                joinPoint.getArgs(),
//                joinPoint.getTarget()
//        );
//    }
//
//    @Pointcut("@annotation(com.annotation.LoggingAnnotation)")
//    public void loggingAnnotation() {
//    }
//
//    @Before("loggingAnnotation()")
//    public void beforeLoggingAnnotation(JoinPoint joinPoint) {
//        logger.info(
//                "Before -> Method: {}, Arguments: {}, Target: {}",
//                joinPoint.getSignature(),
//                joinPoint.getArgs(),
//                joinPoint.getTarget()
//        );
//    }
//
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
//    public void afterReturningGetMappingAnnotation() {}
//
//
//    @AfterReturning(pointcut = "afterReturningGetMappingAnnotation()", returning = "results")
//    public void afterReturningGetMappingOperation(JoinPoint joinPoint, List<CourseDTO> results){
//        logger.info(
//                "After Returning -> Method: {}, Result: {}",
//                joinPoint.getSignature(),
//                results.toString()
//        );
//    }
//
//    @AfterThrowing(pointcut = "afterReturningGetMappingAnnotation()", throwing = "exception")
//    public void afterThrowingGetMappingOperation(JoinPoint joinPoint, RuntimeException exception ){
//        logger.error("After Throwing -> Method: {}, Exception: {}",
//                joinPoint.getSignature().toShortString(),
//                exception.getMessage()
//                );
//    }

    @Pointcut("@annotation(com.cydeo.annotation.LoggingAnnotation)")
    public void loggingAnnotation() {}

    @Around("loggingAnnotation()")
    public Object anyLoggingAnnotationOperation(ProceedingJoinPoint proceedingJoinPoint){
        logger.info("Before -> Method: {} - Parameter: {}",
                proceedingJoinPoint.getSignature().toShortString(),
                proceedingJoinPoint.getArgs()
        );
        Object result = null;
        try{
            result = proceedingJoinPoint.proceed();
        } catch (Throwable t){
            t.printStackTrace();
        }
        logger.info("After -> Method: {} - Result: {}",
                proceedingJoinPoint.getSignature().toShortString(),
                result.toString());
        return result;
    }


}
