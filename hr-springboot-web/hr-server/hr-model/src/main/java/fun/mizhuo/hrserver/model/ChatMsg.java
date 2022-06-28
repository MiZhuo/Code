package fun.mizhuo.hrserver.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: Mizhuo
 * @time: 2020/11/1 3:06 下午
 * @description: 消息聊天对象
 */
public class ChatMsg implements Serializable {

    private String from;
    private String to;
    private String content;
    private Date date;
    private String fromName;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }
}
