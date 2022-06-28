package fun.mizhuo.hrserver.model;

import java.io.Serializable;

/**
 * @author mizhuo
 */
public class Nation implements Serializable {

    private static final long serialVersionUID = 7083341313527899522L;

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

}