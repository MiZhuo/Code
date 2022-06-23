package site.mizhuo.orderserver.entity.DTO;

/**
 * @ClassName SpuDetailDTO
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-08 13:51
 * @Version 1.0
 **/
public class SpuDetailDTO {
    private String description;
    private String specialSpec;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecialSpec() {
        return specialSpec;
    }

    public void setSpecialSpec(String specialSpec) {
        this.specialSpec = specialSpec;
    }
}
