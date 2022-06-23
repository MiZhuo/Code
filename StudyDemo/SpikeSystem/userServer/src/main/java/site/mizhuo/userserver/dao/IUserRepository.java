package site.mizhuo.userserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import site.mizhuo.userserver.entity.DO.UserDO;

import java.util.Optional;

/**
 * @InterfaceName IUserRepository
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-09 11:35
 * @Version 1.0
 **/
public interface IUserRepository extends JpaRepository<UserDO,Long> {

    /***
     * @Author MiZhuo
     * @Description 根据用户名和密码获取用户信息
     * @Date 12:43 下午 2021/10/9
     * @Param [userDO]
     * @return java.util.Optional<site.mizhuo.userserver.entity.DO.UserDO>
     **/
    Optional<UserDO> findUserByUsernameAndPassword(String userName,String Password);

    /***
     * @Author MiZhuo
     * @Description 根据用户手机号获取用户信息
     * @Date 12:43 下午 2021/10/9
     * @Param [phone]
     * @return java.util.Optional<site.mizhuo.userserver.entity.DO.UserDO>
     **/
    Optional<UserDO> findUserByPhone(String phone);
}
