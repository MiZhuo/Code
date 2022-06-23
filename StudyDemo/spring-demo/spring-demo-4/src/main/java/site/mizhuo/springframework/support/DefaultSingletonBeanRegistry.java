package site.mizhuo.springframework.support;

import site.mizhuo.springframework.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DefaultSingletonBeanRegistry
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-24 14:26
 * @Version 1.0
 **/
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    Map<String,Object> singletonObjects = new HashMap<String,Object>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName,Object bean){
        singletonObjects.put(beanName,bean);
    }
}
