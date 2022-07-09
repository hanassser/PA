package com.social.dev.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Data
public class RegisterDTO {

    @NotEmpty(message = "please enter username")
    @Length(min = 2, max = 15, message = "length between 2-15")
    private String name;

    @NotEmpty(message = "please enter password")
    @Length(min = 6, max = 20, message = "length between 6-20")
    private String pass;

    @NotEmpty(message = "please enter password again")
    @Length(min = 6, max = 20, message = "length between 6-20")
    private String checkPass;

    @NotEmpty(message = "please enter email")
    @Email(message = "wrong email format")
    private String email;
}
