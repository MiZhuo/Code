package fun.mizhuo.hrserver.model;

import java.io.Serializable;

/**
 * @author mizhuo
 */
public class EmpSalary implements Serializable {

    private static final long serialVersionUID = -2931268891425340793L;

    private Integer id;

    private Integer eid;

    private Integer sid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
}