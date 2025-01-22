package com.example.agri.controller;

import com.example.agri.Repository.UserRepository;
import com.example.agri.service.UserService;
import com.example.agri.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> getUsers() {
       List<User> users = userService.findAll();
        return ResponseEntity.ok(users);


    }
//    @GetMapping("/api/users")
//    public ResponseEntity<List<User>> getUsers() {
//        return  new ResponseEntity<>(UserService.findAll(), HttpStatus.OK);
//    }
    //    @GetMapping("/user/all")
//    public ResponseEntity<List<User>> getAllUsers() {
//        return  new ResponseEntity<>(UserService.findAll(), HttpStatus.CREATED);
//    }
    @GetMapping("/api/{id}")
    public ResponseEntity<User> getUserById (@PathVariable Long id) {
//        User user=getUsers().findById(id);
        User user = userService.findById(id);
        return ResponseEntity.ok(user);

    }
    @PostMapping("/new-user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
   public ResponseEntity<User> Update(@RequestBody User user,@PathVariable Long id){
        return new ResponseEntity<>(userService.updateUser(user,id),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
