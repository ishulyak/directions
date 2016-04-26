package com.shulyaq.google.annotation.postprocessor;

import com.shulyaq.google.annotation.Directionable;
import com.shulyaq.google.config.DirectionableServices;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class DirectionableAnnotationPostProcessor implements BeanPostProcessor {

    private ConfigurableListableBeanFactory configurableBeanFactory;

    @Autowired
    public DirectionableAnnotationPostProcessor(ConfigurableListableBeanFactory beanFactory) {
        this.configurableBeanFactory = beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        scanForDirectionableAnnotation(bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    private void scanForDirectionableAnnotation(Object bean) {
        if (!bean.getClass().isAnnotationPresent(Directionable.class)) {
            return;
        }
        DirectionableServices ds = (DirectionableServices) configurableBeanFactory.getBean("directionableServices");

        Directionable directionableAnnotation = bean.getClass().getAnnotation(Directionable.class);
        String name = directionableAnnotation.name();

        ds.addService(name, bean);
    }
}
