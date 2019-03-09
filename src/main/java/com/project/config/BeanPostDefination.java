package com.project.config;

import com.project.model.UserModel;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Service;

/**
 * BeanDefinitionRegistryPostProcessor
 * spring 提供的修改bean 的接口 ，可以在进行修改Spring beandefination 的内容，定制
 */
@Service
public class BeanPostDefination implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        int before = registry.getBeanDefinitionCount();
        System.out.println("后置处理之前的bean个数"+before);
        //bean的定义
        GenericBeanDefinition beanDefinition =new GenericBeanDefinition();
        //设置bean class对象交给BeanFactory 进行创建
        beanDefinition.setBeanClass(UserModel.class);
        //也可以给置顶bean 进行属性的添加，底层是一个arraylist
        beanDefinition.getPropertyValues().addPropertyValue("name", "cys");
        //注册到bean工厂中将bean
        registry.registerBeanDefinition("userModel", beanDefinition);
        System.out.println("后置处理之后的bean个数"+registry.getBeanDefinitionCount());
        //删除操作根据名字
        //registry.removeBeanDefinition("xxx");


    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //nothing
    }
}
