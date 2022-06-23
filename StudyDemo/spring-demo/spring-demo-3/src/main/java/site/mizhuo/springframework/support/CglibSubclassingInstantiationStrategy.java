package site.mizhuo.springframework.support;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import site.mizhuo.springframework.config.BeanDefinition;
import site.mizhuo.springframework.config.InstantiationStrategy;

import java.lang.reflect.Constructor;

/**
 * @ClassName CglibSubclassingInstantiationStrategy
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-27 21:48
 * @Version 1.0
 **/
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if(constructor == null ){
            return enhancer.create();
        }
        return enhancer.create(constructor.getParameterTypes(),args);
    }
}
