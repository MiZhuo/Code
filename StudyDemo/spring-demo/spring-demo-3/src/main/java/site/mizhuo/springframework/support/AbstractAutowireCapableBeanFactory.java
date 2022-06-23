package site.mizhuo.springframework.support;

import site.mizhuo.springframework.config.BeanDefinition;
import site.mizhuo.springframework.config.InstantiationStrategy;

import java.lang.reflect.Constructor;

/**
 * @ClassName AbstractAutowireCapableBeanFactory
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-24 14:58
 * @Version 1.0
 **/
public abstract class AbstractAutowireCapableBeanFactory extends  AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition definition, Object[] args) {
        Object bean = null;
        try {
            bean = createBeanInstance(beanName,definition,args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        addSingleton(beanName,bean);
        return bean;
    }

    protected Object createBeanInstance(String beanName, BeanDefinition definition,Object[] args) {
        Constructor constructor = null;
        Class<?> clazz = definition.getBeanClass();
        Constructor<?>[] declaredConstructor = clazz.getDeclaredConstructors();
        for (Constructor<?> ctr : declaredConstructor) {
            if(null != args && ctr.getParameterTypes().length == args.length){
                constructor = ctr;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(definition,beanName,constructor,args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
