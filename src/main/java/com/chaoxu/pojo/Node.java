package com.chaoxu.pojo;

import java.io.Serializable;

/**
 * Created by dell on 2016/6/29.
 */
public class Node implements Serializable {
    private static final long serialVersionUID = -697735307664509644L;
    private Integer id;
    private String nodename;

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", nodename='" + nodename + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNodename() {
        return nodename;
    }

    public void setNodename(String nodename) {
        this.nodename = nodename;
    }
}
