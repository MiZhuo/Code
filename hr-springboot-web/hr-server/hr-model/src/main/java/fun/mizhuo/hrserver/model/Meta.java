package fun.mizhuo.hrserver.model;

import java.io.Serializable;

/**
 * @author: Mizhuo
 * @time: 2020/8/23 10:57 上午
 * @description:
 */
public class Meta implements Serializable {
    private static final long serialVersionUID = -2025626798494693204L;

    private Boolean keepAlive;

    private Boolean requireAuth;

    public Boolean getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(Boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public Boolean getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(Boolean requireAuth) {
        this.requireAuth = requireAuth;
    }
}
