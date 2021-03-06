package com.users.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.users.backend.model.Users;
import com.users.backend.repository.UsersRepository;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UsersRepository usersRepository;

  @GetMapping
  public List<Users> getUsers() {
    return usersRepository.findAll();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Users create(@RequestBody Users user) {
    return usersRepository.save(user);
  }
  
}
