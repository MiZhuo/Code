package site.mizhuo.userserver.service;

import site.mizhuo.userserver.entity.DTO.UserDTO;
import site.mizhuo.userserver.exception.SpikeException;

/**
 * @ClassName IUserService
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-09 11:35
 * @Version 1.0
 **/
public interface IUserService {

    /***
     * @Author MiZhuo
     * @Description 获取用户信息
     * @Date 12:34 下午 2021/10/9
     * @Param [userDTO]
     * @return site.mizhuo.userserver.entity.DTO.UserDTO
     **/
    UserDTO getUser(UserDTO userDTO) throws SpikeException;

    /***
     * @Author MiZhuo
     * @Description 新增用户
     * @Date 12:35 下午 2021/10/9
     * @Param [userDTO]
     * @return void
     **/
    void insertUser(UserDTO userDTO) throws SpikeException;
}
