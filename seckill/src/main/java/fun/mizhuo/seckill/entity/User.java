package fun.mizhuo.seckill.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author mizhuo
 * @since 2022-05-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {


    @ApiModelProperty(value = "用户ID,手机号")
    private Long id;

    private String nickname;

    @ApiModelProperty(value = "MD5(MD5(明文+盐)+盐)")
    @TableField("`password`")
    private String password;

    private String salt;

    @ApiModelProperty(value = "头像")
    private String head;

    @ApiModelProperty(value = "注册时间")
    @TableField("register_date")
    private LocalDateTime registerDate;

    @ApiModelProperty(value = "最后一次登录时间")
    @TableField("last_login_date")
    private LocalDateTime lastLoginDate;

    @ApiModelProperty(value = "登录失败次数")
    @TableField("login_failed_count")
    private Integer loginFailedCount;

    @ApiModelProperty(value = "是否锁定")
    private Integer locked;


}
