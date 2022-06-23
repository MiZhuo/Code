package site.mizhuo.springframework.exception;

/**
 * @ClassName GlobalException
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-24 15:45
 * @Version 1.0
 **/
public class GlobalException extends RuntimeException{

    public GlobalException(String message) {
        super(message);
    }

    public GlobalException(String message, Throwable cause) {
        super(message, cause);
    }
}
