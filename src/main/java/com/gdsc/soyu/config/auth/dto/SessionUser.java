package com.gdsc.soyu.config.auth.dto;

import com.gdsc.soyu.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;
    private Long id;

    public SessionUser(User user){
        this.id= user.getId();
        this.name=user.getName();
        this.email=user.getEmail();
        this.picture=user.getPicture();
    }
}
