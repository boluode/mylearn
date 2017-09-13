package com.boluo.mylearn.spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * mylearn com.boluo.mylearn.spring
 *
 * @Author boluo
 * @Date 2017/9/12 7:40
 * @since JDK 1.8
 */
public class DynamicProxy implements InvocationHandler {
    private Object object;

    public Object bind(Object target) {

        this.object = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("before DynamicProxy");
        result = method.invoke(object, args);
        System.out.println("after DynamicProxy");
        return result;
    }
}
