package site.mizhuo.designpattern.prototype;

/**
 * @ClassName Mobile
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-30 21:47
 * @Version 1.0
 **/
public abstract class Mobile implements Cloneable {
    private String name;
    protected String type;

    public abstract void mobileModel();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    protected Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
