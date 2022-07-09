package com.social.dev.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
public class LoginDTO {

    @NotBlank(message = "username can't be empty")
    @Size(min = 2, max = 15, message = "username's length should between 2-15")
    private String username;

    @NotBlank(message = "password can't be empty")
    @Size(min = 6, max = 20, message = "password's length should between 6-20")
    private String password;

    private Boolean rememberMe;
}
