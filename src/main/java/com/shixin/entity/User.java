package com.shixin.entity;

/**
 * @author 今何许
 * @date 2020-08-14 14:03
 */

/**
 * user
 */
public class User {
    /**
     * id
     */
    private String id;

    /**
     * name
     */
    private String name;

    /**
     * password
     */
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}