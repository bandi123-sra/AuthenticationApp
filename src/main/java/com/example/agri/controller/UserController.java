package com.example.agri.controller;

import com.example.agri.service.UserService;
import com.example.agri.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping()
    public String getUsers() {

        return "I am User.";
    }
}
