package fun.mizhuo.hrserver.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author mizhuo
 */
public class Appraise implements Serializable {
    private static final long serialVersionUID = 5127569351863705845L;

    private Integer id;

    private Integer eid;

    private Date appDate;

    private String appResult;

    private String appContent;

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

    public Date getAppDate() {
        return appDate;
    }

    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }

    public String getAppResult() {
        return appResult;
    }

    public void setAppResult(String appResult) {
        this.appResult = appResult;
    }

    public String getAppContent() {
        return appContent;
    }

    public void setAppContent(String appContent) {
        this.appContent = appContent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}