package fun.mizhuo.hrserver.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author mizhuo
 */
public class EmployeeTrain implements Serializable {

    private static final long serialVersionUID = 2774372892659998520L;

    private Integer id;

    private Integer eid;

    private Date trainDate;

    private String trainContent;

    private String remark;

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

    public Date getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(Date trainDate) {
        this.trainDate = trainDate;
    }

    public String getTrainContent() {
        return trainContent;
    }

    public void setTrainContent(String trainContent) {
        this.trainContent = trainContent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}