package site.mizhuo.storageserver.exception;

/**
 * @ClassName SpikeException
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-07 22:22
 * @Version 1.0
 **/
public class SpikeException extends Exception {
    public SpikeException() {
    }

    public SpikeException(String message) {
        super(message);
    }

    public SpikeException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpikeException(Throwable cause) {
        super(cause);
    }

    public SpikeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
