package site.mizhuo.springframework.support;

import site.mizhuo.springframework.config.BeanDefinition;
import site.mizhuo.springframework.config.InstantiationStrategy;
import site.mizhuo.springframework.exception.GlobalException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName SimpleInstantiationStrategy
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-25 22:31
 * @Version 1.0
 **/
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor,Object[] args) {
        Class clazz = beanDefinition.getBeanClass();
        try {
            if(null != constructor){
                return clazz.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            }else{
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |  NoSuchMethodException e) {
            throw new GlobalException("初始化类失败!");
        }
    }
}
