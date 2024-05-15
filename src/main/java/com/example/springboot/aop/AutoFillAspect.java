package com.example.springboot.aop;

import com.example.springboot.annotation.AutoFill;
import com.example.springboot.contant.AutoFillConstant;
import com.example.springboot.contant.OperationType;
import com.example.springboot.utils.BaseContext;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * 自定义切片，实现公共字段字段填充
 */
@Aspect
@Component
@Slf4j
public class AutoFillAspect {

    /**
     * 切入点
     * @Pointcut注解表示切入点的表达式有多种，最常用的是两种，execution表达式和@annotation注解；
     * execution(* com.example.springboot.mapper.*.*(..)) 表示 com.sky.mapper包下所有类的所有方法
     * @annotation(com.example.springboot.annotation.AutoFill) 表示 com.sky.annotion包下的AutoFill注解
     */
    @Pointcut("execution(* com.example.springboot.mapper.*.*(..)) && @annotation(com.example.springboot.annotation.AutoFill)")
    public void autoFillPointCut(){}

    /**
     * 前置通知，在通知中进行公共字段赋值
     * 可以joinpoint中得到命中方法的相关信息，利用这些信息可以做一些额外的业务操作；
     * @Before("autoFillPointCut()") 表示接入点为autoFillPointCut()的切入点
     */
    @Before("autoFillPointCut()")
    public void autoFill(JoinPoint joinPoint){
        log.info("开始公共字段自动填充...");
        //获取到当前被拦截的方法上的数据库操作类型
        MethodSignature signature=(MethodSignature) joinPoint.getSignature();//对象方法签名
        AutoFill autoFill = signature.getMethod().getAnnotation(AutoFill.class);//获得方法上的注解对象
        OperationType values = autoFill.values();//获得数据库操作对象
        //获取到当前被拦截的方法的参数--实体对象
        Object[] args = joinPoint.getArgs();
        if(args==null||args.length==0) {return;}
        Object entity = args[0];
        //准备赋值的数据
        LocalDateTime localDateTime = LocalDateTime.now();
        Long currentId = BaseContext.getCurrentId();
        //根据当前不同的操作类型，为对应属性通过反射来赋值
        if(values==OperationType.INSERT){
            try {
                Method setCreateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_CREATE_TIME, LocalDateTime.class);
                Method setCreateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_CREATE_USER, Long.class);
                Method setUpdateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);
                Method setUpdateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_USER, Long.class);
                setCreateTime.invoke(entity,localDateTime);
                setCreateUser.invoke(entity,currentId);
                setUpdateTime.invoke(entity,localDateTime);
                setUpdateUser.invoke(entity,currentId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(values==OperationType.UPDATE){
            try {
                Method setUpdateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);
                Method setUpdateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_USER, Long.class);
                setUpdateTime.invoke(entity,localDateTime);
                setUpdateUser.invoke(entity,currentId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}