package site.mizhuo.springframework.support;

import site.mizhuo.springframework.BeanFactory;
import site.mizhuo.springframework.config.BeanDefinition;
import site.mizhuo.springframework.exception.GlobalException;

/**
 * @ClassName AbstractBeanFactory
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-24 14:39
 * @Version 1.0
 **/
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws GlobalException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws GlobalException {
        return doGetBean(name, args);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String name);

    protected abstract Object createBean(String beanName, BeanDefinition definition,Object[] args);
}
