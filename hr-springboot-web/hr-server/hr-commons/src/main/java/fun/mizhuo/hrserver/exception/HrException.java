package fun.mizhuo.hrserver.exception;

import java.io.Serializable;

/**
 * @author: Mizhuo
 * @time: 2020/9/28 11:22 上午
 * @description: 自定义异常
 */
public class HrException extends Exception implements Serializable {

    private static final long serialVersionUID = -3409237399800688309L;

    private String msg;
    private String code;
    protected Throwable cause;

    /**
     * @param msg 错误信息
     */
    public HrException(String msg) {
        this.msg = msg;
        this.code = null;
        this.cause = null;
    }

    /**
     * @param msg 错误信息
     * @param code 错误码
     */
    public HrException(String code,String msg) {
        this.msg = msg;
        this.code = code;
        this.cause = null;
    }

    /**
     * @param code 错误码
     * @param msg 错误信息
     * @param cause 异常
     */
    public HrException(String code,String msg,Throwable cause) {
        this(code,msg);
        this.cause = cause;
    }

    /**
     * @param msg 错误信息
     * @param cause 异常
     */
    public HrException(String msg,Throwable cause){
        this(msg);
        this.cause = cause;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }

    /**
     * 获取异常具体信息
     * @return
     */
    public StringBuffer getStack(){
        StringBuffer stack = new StringBuffer();
        StackTraceElement[] trace = this.getStackTrace();
        for (StackTraceElement element : trace) {
            stack.append("\tat " + element + "<br/>");
        }
        return stack;
    }
}
