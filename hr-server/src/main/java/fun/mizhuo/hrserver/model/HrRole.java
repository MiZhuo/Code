package fun.mizhuo.hrserver.model;

import java.io.Serializable;

/**
 * @author mizhuo
 */
public class HrRole implements Serializable {

    private static final long serialVersionUID = 3239870095920795300L;

    private Integer id;

    private Integer hrid;

    private Integer rid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHrid() {
        return hrid;
    }

    public void setHrid(Integer hrid) {
        this.hrid = hrid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

}