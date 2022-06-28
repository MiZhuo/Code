package site.mizhuo.springframework;

/**
 * @ClassName BeanDefinition
 * @Description: 定义Bean的实例化信息
 * @Author: MiZhuo
 * @Create: 2021-09-23 22:22
 * @Version 1.0
 **/
public class BeanDefinition {
    Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
