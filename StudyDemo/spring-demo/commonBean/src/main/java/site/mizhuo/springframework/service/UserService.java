package site.mizhuo.springframework.service;

import site.mizhuo.springframework.dao.UserDao;

/**
 * @ClassName UserService
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-29 21:33
 * @Version 1.0
 **/
public class UserService {

    private UserDao userDao;

    public String queryUserInfo(String id){
       return userDao.queryNameById(id);
    }
}
