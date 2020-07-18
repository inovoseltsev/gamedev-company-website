package com.inovoseltsev.lightdev.model.entity;

import com.inovoseltsev.lightdev.model.state.State;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Map;

@Entity
@Table(name = "O_AUTH2_GOOGLE_USER")
public class OAuth2GoogleUser {
    @Id
    @Column(name = "USER_ID")
    private String id;
    @Column(name = "NAME")
    private String nickname;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL", unique = true)
    private String email;
    @Column(name = "LOCALE")
    private String locale;
    @Column(name = "STATE")
    @Enumerated(value = EnumType.STRING)
    private State state;

    public OAuth2GoogleUser() {
    }

    public OAuth2GoogleUser(Map<String, Object> userAttributes) {
        this.id = (String) userAttributes.get("sub");
        this.nickname = (String) userAttributes.get("name");
        this.email = (String) userAttributes.get("email");
        this.locale = (String) userAttributes.get("locale");
        this.firstName = "";
        this.lastName = "";
        this.state = State.ACTIVE;
    }

    public OAuth2GoogleUser(String id, String nickname, String firstName,
                            String lastName,
                            String email, String locale, State state) {
        this.id = id;
        this.nickname = nickname;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.locale = locale;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String name) {
        this.nickname = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firsName) {
        this.firstName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public State getState() {
        if (state == null) {
            state = State.ACTIVE;
        }
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}