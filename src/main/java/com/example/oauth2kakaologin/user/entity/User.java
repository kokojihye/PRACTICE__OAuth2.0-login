package com.example.oauth2kakaologin.user.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본생성자
@DynamicUpdate //update할때 실제 값이 변경됨 컬럼으로 update 쿼리 만듬
@Entity
@Getter
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "provider", nullable = false)
    private String provider;
    /*
    * 소셜 로그인 중 email과 provider를 통해 이미 생성된 사용자인지 처음 가입하는 사용자인지 판단합니다.
    * email과 provider를 둔 이유는 email의 경우는 중복될 수 있다고 판단했습니다.
    * 예를 들면 구글에서는 A@naver.com과 같이 이메일 등록이 가능합니다.
    * 이때 사용자 B가 A@naver.com이라는 이메일을 가지고 있다면 email만으로 서로 다른 사용자를 구분하지 못합니다.
    * 따라서 email과 provider를 같이 사용하여 서로 다른 사용자를 구분하고자 합니다.
    * */

    @Column(name = "nickname", nullable = false, unique = true)
    private String nickname;

    @Builder

    public User(Long id, String name, String email, String provider, String nickname) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.provider = provider;
        this.nickname = nickname;
    }

    public User update(String name, String email) {
        this.name = name;
        this.email = email;
        return this;
    }
}
