package fun.mizhuo.seckill.utils;

import cn.hutool.crypto.digest.MD5;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * @ClassName: MD5Util
 * @Author: MiZhuo
 * @Date: 2022/5/29 11:57
 * @Description: MD5加密工具
 */
public class MD5Util {

    private static final byte[] salt = {'m','i','z','h','u','o'};

    public static String inputPassToDbPass(String password,String userSalt){
        return MD5.create().setSalt(userSalt.getBytes(StandardCharsets.UTF_8)).setSaltPosition(3).digestHex(password);
    }

    public static void main(String[] args) {
        System.out.println(MD5.create().setSalt("aimiaomiao".getBytes(StandardCharsets.UTF_8)).setSaltPosition(3).digestHex(MD5.create().setSalt(salt).setSaltPosition(2).digestHex("mizhuo")));
    }
}
