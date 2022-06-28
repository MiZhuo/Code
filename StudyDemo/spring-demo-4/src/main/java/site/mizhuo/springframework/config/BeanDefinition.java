package site.mizhuo.springframework.config;

import site.mizhuo.springframework.PropertyValue;
import site.mizhuo.springframework.PropertyValues;

/**
 * @ClassName BeanDefinition
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-24 14:28
 * @Version 1.0
 **/
public class BeanDefinition {
    private Class BeanClass;

    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        this.BeanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.BeanClass = beanClass;
        this.propertyValues = propertyValues == null ? new PropertyValues() : propertyValues;
    }

    public Class getBeanClass() {
        return BeanClass;
    }

    public void setBeanClass(Class beanClass) {
        BeanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
