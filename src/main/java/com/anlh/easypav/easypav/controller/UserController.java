package com.anlh.easypav.easypav.controller;

import com.anlh.easypav.easypav.domain.Project;
import com.anlh.easypav.easypav.domain.User;
import com.anlh.easypav.easypav.dto.receive.LoginDto;
import com.anlh.easypav.easypav.dto.receive.RegisterDto;
import com.anlh.easypav.easypav.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping
    public User loginByUser(@RequestBody LoginDto login){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<User> foundUser = service.findUserByEmail(login.getEmail());
        if(foundUser.isPresent()){
            User user = foundUser.get();
            if(encoder.matches(login.getPassword(), user.getPassword())){
                return user;
            }
        }
        return null;
    }

    @PostMapping
    public User registerUser(@RequestBody RegisterDto user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        User newUser = new User(user);
        return service.registerNewUser(newUser);
    }

    @GetMapping("/{id}/projects")
    public List<Project> getProjects(@PathVariable Integer id){
        Optional<User> user = service.findUserById(id);
        return user.map(User::getProjects).orElse(null);
    }

}
