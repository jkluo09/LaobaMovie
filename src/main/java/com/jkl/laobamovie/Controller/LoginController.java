package com.jkl.laobamovie.Controller;

import com.jkl.laobamovie.Entity.User;
import com.jkl.laobamovie.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class LoginController{

    @Autowired
    UserRepository userRepository;

    @GetMapping("/Login")
    @CrossOrigin(origins = "*")
    public User Login(@RequestParam("username") String username){
        return userRepository.findbyUsername(username);
    }

    @GetMapping("/register")
    @CrossOrigin(origins = "*")
    public User regis(@RequestParam("username") String username,
                         @RequestParam("password") String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userRepository.save(user);
    }

}
