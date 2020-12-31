package com.grizzly.base.annotation.custom;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCustomAnnotation {

    @CustomAnnotation
    public static void testCustomAnnotation(){
        System.out.println("通过反射调用testCustomAnnotation");
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz = Class.forName("com.grizzly.base.annotation.custom.TestCustomAnnotation");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods){
            Annotation annotation = method.getAnnotation(CustomAnnotation.class);
            if (annotation != null){
                System.out.println(method.getName() + " 方法包含注解 CustomAnnotation");
                method.invoke(clazz.newInstance());
            }else{
                System.out.println(method.getName() + " 方法不包含注解 CustomAnnotation");
            }
        }
    }
}
