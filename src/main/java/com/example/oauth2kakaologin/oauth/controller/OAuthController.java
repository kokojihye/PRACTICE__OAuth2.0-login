package com.example.oauth2kakaologin.oauth.controller;

import com.example.oauth2kakaologin.user.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.memory.UserAttribute;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Name;
import java.util.Map;

@RestController
@RequestMapping("/oauth")
public class OAuthController {
    @GetMapping("/loginInfo")
    public String oauthLoginInfo(Authentication authentication){
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        Map<String, Object> attributes = oAuth2User.getAttributes();
        return attributes.toString();
    }
}
