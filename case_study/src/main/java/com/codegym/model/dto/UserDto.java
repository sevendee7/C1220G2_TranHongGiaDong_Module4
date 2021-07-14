package com.codegym.model.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class UserDto {
    @NotEmpty(message = "Email can't be blank")
    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$", message = "Email format invalid")
    @Column(unique = true)
    private String email;

    @NotEmpty(message = "Password can't be blank")
    private String password;

    @NotEmpty(message = "Confirm password incorrect")
    private String matchingPassword;

    public UserDto() {
    }

    public UserDto(@NotEmpty(message = "Email can't be blank") @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$", message = "Email format invalid") String email, @NotEmpty(message = "Password can't be blank") String password, @NotEmpty(message = "Confirm password incorrect") String matchingPassword) {
        this.email = email;
        this.password = password;
        this.matchingPassword = matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

}

