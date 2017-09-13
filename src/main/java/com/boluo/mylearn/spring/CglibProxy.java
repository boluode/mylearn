package com.boluo.mylearn.spring;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * mylearn com.boluo.mylearn.spring
 *
 * @Author boluo
 * @Date 2017/9/13 7:34
 * @since JDK 1.8
 */
public class CglibProxy implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target){

        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("before DynamicProxy");
        methodProxy.invoke(target, objects);
        System.out.println("after DynamicProxy");
        return null;
    }
}
