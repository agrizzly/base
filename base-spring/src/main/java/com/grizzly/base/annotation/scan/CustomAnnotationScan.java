package com.grizzly.base.annotation.scan;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class CustomAnnotationScan implements BeanPostProcessor {

    private final List<Class<? extends Annotation>> annotations =
            Arrays.asList(MyAnnotation.class);

    private Class originalBeanClass;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        final AtomicBoolean add = new AtomicBoolean();
        ReflectionUtils.doWithMethods(bean.getClass(),
                new ReflectionUtils.MethodCallback() {
                    @Override
                    public void doWith(Method method) throws IllegalArgumentException,
                            IllegalAccessException {
                        add.set(true);
                    }
                },
                new ReflectionUtils.MethodFilter() {
                    @Override
                    public boolean matches(Method method) {
                        for (Class<? extends Annotation> annotationClass : annotations) {
                            if (method.isAnnotationPresent(annotationClass)) {
                                return true;
                            }
                        }
                        return false;
                    }
                });

        if (add.get()) {
            originalBeanClass = bean.getClass();
        }
        return bean;
    }
}
