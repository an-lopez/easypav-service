package com.anlh.easypav.easypav.domain;

import com.anlh.easypav.easypav.dto.receive.RegisterDto;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String lastname;
    private String email;
    private String password;

    //This way we can track how many schools or labs are using our app.
    private String school;

    private List<Project> projects;

    public User() {
    }

    public User(RegisterDto registerDto) {
        this.name = registerDto.getName();
        this.lastname = registerDto.getLastname();
        this.email = registerDto.getEmail();
        this.password = registerDto.getPassword();
        this.school = registerDto.getSchool();
    }
}
