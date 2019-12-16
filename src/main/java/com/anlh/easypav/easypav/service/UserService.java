package com.anlh.easypav.easypav.service;

import com.anlh.easypav.easypav.domain.User;
import com.anlh.easypav.easypav.dto.receive.LoginDto;
import com.anlh.easypav.easypav.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public User registerNewUser(User user){
        return repository.save(user);
    }

    public Optional<User> findUserByEmail(String email){
        return repository.findByEmail(email);
    }

    public Optional<User> findUserById(Integer id){
        return repository.findById(id);
    }
}
