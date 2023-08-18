package kr.co.seoulit.insa.sys;


import javax.servlet.http.HttpServletRequest;

import kr.co.seoulit.insa.commsvc.systemmgmt.exception.IdNotFoundException;
import kr.co.seoulit.insa.commsvc.systemmgmt.exception.PwMissMatchException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Aspect
@Configuration
@EnableAspectJAutoProxy
public class CommonAspect2 {
    private static final Logger log = LoggerFactory.getLogger(CommonAspect2.class);
    public CommonAspect2() {
    }
    @ExceptionHandler({IdNotFoundException.class})
    public ModelAndView idNotFoundExceptionHandler(HttpServletRequest request, IdNotFoundException e) {
        ModelAndView mv = new ModelAndView("/hr/loginform");
        mv.addObject("errorCode", -2);
        mv.addObject("errorMsg", e.getMessage());
        System.out.println("#######################IdNotFoundException#################1");
        Logger var10000 = log;
        StringBuffer var10001 = request.getRequestURL();
        var10000.error("Request: " + var10001 + "\n raised " + e);
        return mv;
    }

    @ExceptionHandler({PwMissMatchException.class})
    public ModelAndView pwMissMatchException(HttpServletRequest request, PwMissMatchException e) {
        ModelAndView mv = new ModelAndView("/hr/loginform");
        mv.addObject("errorCode", -4);
        mv.addObject("errorMsg", e.getMessage());
        System.out.println("#######################PwMissMatchException#################1");
        Logger var10000 = log;
        StringBuffer var10001 = request.getRequestURL();
        var10000.error("Request: " + var10001 + "\n raised " + e);
        return mv;
    }
    @ExceptionHandler({DataAccessException.class})
    public ModelAndView pwNotFoundExceptionHandler(HttpServletRequest request, DataAccessException e) {
        ModelAndView mv = new ModelAndView("/errorPage");
        mv.addObject("errorCode", -3);
        mv.addObject("errorMsg", e.getMessage());
        System.out.println("#####################DataAccessException###################1");
        Logger var10000 = log;
        StringBuffer var10001 = request.getRequestURL();
        var10000.error("Request: " + var10001 + "\n raised " + e);
        return mv;
    }
    @ExceptionHandler({Exception.class})
    public ModelAndView defaultExceptionHandler(HttpServletRequest request, Exception exception) {
        ModelAndView mv = new ModelAndView("/errorPage");
        mv.addObject("exception", exception);
        System.out.println("******************** 전체익셉션");
        log.error("defaultExceptionHandler", exception);
        return mv;
    }

    @Component
    @Aspect
    public class LoggerAspect {
        public LoggerAspect() {
        }

        @Around("execution(* kr..controller.*.*(..)) or execution(* kr..service.*.*(..)) or execution(* kr..mapper.*.*(..))")
        public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable {
            String type = "";
            String name = joinPoint.getSignature().getDeclaringTypeName();
            if (name.indexOf("Controller") > -1) {
                type = "Controller  \t:  ";
            } else if (name.indexOf("Service") > -1) {
                type = "ServiceImpl  \t:  ";
            } else if (name.indexOf("Mapper") > -1) {
                type = "Mapper  \t\t:  ";
            }

            System.out.println(type + name + "." + joinPoint.getSignature().getName() + "()⭐");
            return joinPoint.proceed();
        }
    }
}