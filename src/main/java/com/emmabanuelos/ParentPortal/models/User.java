package com.emmabanuelos.ParentPortal.models;

import com.sun.istack.NotNull;
import org.dom4j.tree.AbstractEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;

@Entity
public class User extends AbstractEntity {
    @NotNull
    private String username;

    @NotNull
    private String pwHash;
    private Object id;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    public String getUsername() {
        return username;
    }

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

//
//    public Object getId() {
//    return id;
//    }
}
