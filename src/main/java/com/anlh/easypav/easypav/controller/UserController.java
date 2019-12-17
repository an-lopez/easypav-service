package com.anlh.easypav.easypav.controller;

import com.anlh.easypav.easypav.domain.Project;
import com.anlh.easypav.easypav.domain.User;
import com.anlh.easypav.easypav.dto.receive.LoginDto;
import com.anlh.easypav.easypav.dto.receive.RegisterDto;
import com.anlh.easypav.easypav.exception.AppException;
import com.anlh.easypav.easypav.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/login")
    public User loginByUser(@RequestBody LoginDto login) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = service.findUserByEmail(login.getEmail()).orElseThrow(() -> new AppException("Wrong user"));
        if (encoder.matches(login.getPassword(), user.getPassword()))
            return user;
        else
            throw new AppException("Wrong user");
    }

    @PostMapping
    public User registerUser(@RequestBody RegisterDto user) {
        if (service.findUserByEmail(user.getEmail()).isPresent())
            throw new AppException("Cloned user");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        User newUser = new User(user);
        return service.registerNewUser(newUser);
    }

    @GetMapping("/{id}/projects")
    public List<Project> getProjects(@PathVariable Integer id) {
        Optional<User> user = service.findUserById(id);
        return null;
        //return user.map(User::getProjects).orElse(null);
    }


}
