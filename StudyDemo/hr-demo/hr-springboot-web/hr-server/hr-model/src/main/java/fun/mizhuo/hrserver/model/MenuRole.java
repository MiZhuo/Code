package fun.mizhuo.hrserver.model;

import java.io.Serializable;

/**
 * @author mizhuo
 */
public class MenuRole implements Serializable {

    private static final long serialVersionUID = -8949763816826119853L;

    private Integer id;

    private Integer mid;

    private Integer rid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

}