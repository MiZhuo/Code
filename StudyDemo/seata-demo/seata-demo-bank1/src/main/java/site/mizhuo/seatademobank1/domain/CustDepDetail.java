package site.mizhuo.seatademobank1.domain;

/**
 * @author: Mizhuo
 * @time: 2021/3/29 10:24 下午
 * @description:
 */
public class CustDepDetail{
    private Integer id;
    private String name;
    private double depBal;
    private String etlDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDepBal() {
        return depBal;
    }

    public void setDepBal(double depBal) {
        this.depBal = depBal;
    }

    public String getEtlDate() {
        return etlDate;
    }

    public void setEtlDate(String etlDate) {
        this.etlDate = etlDate;
    }
}
