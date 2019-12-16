package com.anlh.easypav.easypav.dto.receive;

import lombok.Data;

import javax.persistence.*;

@Data
public class RegisterDto {

    private String name;
    private String lastname;
    private String email;
    private String password;

    //This way we can track how many schools or labs are using our app.
    private String school;

}
