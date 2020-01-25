package com.gun.entry.controller;

import com.gun.entry.domain.User;
import com.gun.entry.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/hello/{name}")
    String hello(@PathVariable String name) {
          return "Hello, " + name + "!";
    }

    @GetMapping
    @ResponseBody
    public Map<String, User> findAll() {
        return userRepository.findAll();
    }

    @PostMapping
    @ResponseBody
    public User add(@RequestBody User user) {
     userRepository.save(user);
     return userRepository.findById(user.getId());
    }

}
