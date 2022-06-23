package site.mizhuo.springframework.config;

/**
 * @ClassName BeanReference
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-29 17:28
 * @Version 1.0
 **/
public class BeanReference {

    private String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

}
