package site.mizhuo.userserver.entity.VO;

import java.io.Serializable;

/**
 * @ClassName ResultVO
 * @Description: 统一返回对象
 * @Author: MiZhuo
 * @Create: 2021-10-06 14:49
 * @Version 1.0
 **/
public class ResultVO<T> implements Serializable{
    /**
     * 通信数据
     */
    private T data;
    /**
     * 通信状态
     */
    private Boolean flag;
    /**
     * 通信描述
     */
    private String msg ;
    /**
     * 通过静态方法获取实例
     */
    public static <T> ResultVO<T> of(T data) {
        return new ResultVO<>(data);
    }

    public static <T> ResultVO<T> of(T data, Boolean flag) {
        return new ResultVO<>(data, flag);
    }

    public static <T> ResultVO<T> of(T data, Boolean flag, String msg) {
        return new ResultVO<>(data, flag, msg);
    }

    @Deprecated
    public ResultVO() {

    }

    private ResultVO(T data) {
        this.data = data;
    }

    private ResultVO(T data, Boolean flag) {
        this.data = data;
        this.flag = flag;
    }

    private ResultVO(T data, Boolean flag, String msg) {
        this.data = data;
        this.flag = flag;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResultVO{" +
                "data=" + data +
                ", flag=" + flag +
                ", msg='" + msg + '\'' +
                '}';
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}