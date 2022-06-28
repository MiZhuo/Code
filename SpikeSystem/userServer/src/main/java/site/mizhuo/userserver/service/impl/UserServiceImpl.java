package site.mizhuo.userserver.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.mizhuo.userserver.dao.IUserRepository;
import site.mizhuo.userserver.entity.DO.UserDO;
import site.mizhuo.userserver.entity.DTO.UserDTO;
import site.mizhuo.userserver.entity.VO.UserVO;
import site.mizhuo.userserver.exception.SpikeException;
import site.mizhuo.userserver.service.IUserService;
import site.mizhuo.userserver.utils.BeanConvertUtils;

import java.util.Optional;

/**
 * @ClassName UserServiceImpl
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-09 11:36
 * @Version 1.0
 **/
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository userRepository;


    @Override
    public UserDTO getUser(UserDTO userDTO) throws SpikeException {
        UserDO userDO = BeanConvertUtils.copyProperties(userDTO, UserDO.class);
        Optional<UserDO> optionalUserDO = userRepository.findUserByUsernameAndPassword(userDO.getUsername(),userDO.getPassword());
        if(!optionalUserDO.isPresent()){
            log.error("用户名或密码错误!");
            throw new SpikeException("用户名或密码错误!");
        }
        return BeanConvertUtils.copyProperties(optionalUserDO.get(),UserDTO.class);
    }

    @Override
    public void insertUser(UserDTO userDTO) throws SpikeException {
        UserDO userDO = BeanConvertUtils.copyProperties(userDTO, UserDO.class);
        Optional<UserDO> optionalUserDO = userRepository.findUserByPhone(userDO.getPhone());
        if(optionalUserDO.isPresent()){
            log.error("用户已存在!");
            throw new SpikeException("用户已存在!");
        }
        userDO = userRepository.saveAndFlush(userDO);
    }
}
