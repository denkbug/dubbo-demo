package com.denk.demo.base.model;

/**
 * @author: denk
 * desc:
 * date: 2018/3/6
 */
public class User implements java.io.Serializable {
    private String id;
    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
