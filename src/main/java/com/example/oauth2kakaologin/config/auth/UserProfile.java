package com.example.oauth2kakaologin.config.auth;

import com.example.oauth2kakaologin.user.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfile {
    private String name;
    private String email;
    private String provider;
    private String nickname;

    public User toUser() {
        return User.builder()
                .name(name)
                .email(email)
                .provider(provider)
                .build();
    }
}
