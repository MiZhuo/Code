package site.mizhuo.springframework.config;

/**
 * @ClassName BeanDefinition
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-24 14:28
 * @Version 1.0
 **/
public class BeanDefinition {
    private Class BeanClass;

    public BeanDefinition(Class beanClass) {
        BeanClass = beanClass;
    }

    public Class getBeanClass() {
        return BeanClass;
    }

    public void setBeanClass(Class beanClass) {
        BeanClass = beanClass;
    }
}
