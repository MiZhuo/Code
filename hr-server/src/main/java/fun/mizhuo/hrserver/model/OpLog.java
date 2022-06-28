package fun.mizhuo.hrserver.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author mizhuo
 */
public class OpLog implements Serializable {

    private static final long serialVersionUID = 1415308724208777053L;

    private Integer id;

    private Date addDate;

    private String operate;

    private Integer hrId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public Integer getHrId() {
        return hrId;
    }

    public void setHrId(Integer hrId) {
        this.hrId = hrId;
    }
}