package com.example.oauth2kakaologin.user.repository;

import com.example.oauth2kakaologin.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //이미 생성된 사용자인지, 처음 가입하는 사용자인지 판단
    Optional<User> findByEmailAndProvider(String email, String provider);
}
