package site.mizhuo.springframework;

/**
 * @ClassName PropertyValue
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-29 17:19
 * @Version 1.0
 **/
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
