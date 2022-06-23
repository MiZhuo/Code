package site.mizhuo.designpattern.singleton;

/**
 * @ClassName User
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-29 17:31
 * @Version 1.0
 **/
public class User {
    private User(){};
    static enum SingletonEnum{
        INSTANCE;
        private User user;
        private SingletonEnum(){
            user = new User();
        }
        public User getUser(){
            return user;
        }
    }

    public static User getInstance(){
        return SingletonEnum.INSTANCE.getUser();
    }
}
