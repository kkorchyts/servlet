package com.kkorchyts.jwd.model.building;

import com.kkorchyts.jwd.model.Role;
import com.kkorchyts.jwd.model.User;

import java.util.HashSet;
import java.util.Set;

public class UserBuilder extends AbstractBuilder<User>{

    private Integer id;
    private String login;
    private String password;
    private String firsName;
    private String lastName;
    private String email;
    private String address;
    private Set<Role> roles = new HashSet<>();

    public static UserBuilder builder() {
        return new UserBuilder();
    }


    public UserBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public UserBuilder login(String login) {
        this.login = login;
        return this;
    }

    public UserBuilder password(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder firsName(String firsName) {
        this.firsName = firsName;
        return this;
    }

    public UserBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder address(String address) {
        this.address = address;
        return this;
    }

    public UserBuilder roles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    @Override
    public User build() {
        User newUser = new User();
        newUser.setId(id);
        newUser.setLogin(login);
        newUser.setPassword(password);
        newUser.setFirsName(firsName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setAddress(address);
        newUser.setRoles(roles);
        return newUser;
    }
}
