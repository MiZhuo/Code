package site.mizhuo.springframework.support;

import site.mizhuo.springframework.BeanFactory;
import site.mizhuo.springframework.config.BeanDefinition;

/**
 * @ClassName AbstractBeanFactory
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-24 14:39
 * @Version 1.0
 **/
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) {
        Object beanSingleton = getSingleton(name);
        if(beanSingleton != null){
            return beanSingleton;
        }
        BeanDefinition definition = getBeanDefinition(name);
        return createBean(name,definition);
    }

    protected abstract BeanDefinition getBeanDefinition(String name);

    protected abstract Object createBean(String beanName, BeanDefinition definition);
}
