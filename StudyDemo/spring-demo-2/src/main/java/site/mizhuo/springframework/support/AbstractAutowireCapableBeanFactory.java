package site.mizhuo.springframework.support;

import site.mizhuo.springframework.config.BeanDefinition;

/**
 * @ClassName AbstractAutowireCapableBeanFactory
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-24 14:58
 * @Version 1.0
 **/
public abstract class AbstractAutowireCapableBeanFactory extends  AbstractBeanFactory{

    @Override
    protected Object createBean(String beanName, BeanDefinition definition) {
        Object bean = null;
        try {
            bean = definition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        addSingleton(beanName,bean);
        return bean;
    }
}
