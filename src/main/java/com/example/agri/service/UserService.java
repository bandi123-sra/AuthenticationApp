package com.example.agri.service;
import com.example.agri.Entity.User;
import com.example.agri.Repository.UserRepository;
//import org.apache.catalina.Group;
//import org.apache.catalina.Role;
//import org.apache.catalina.User;
//import org.apache.catalina.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
//    public static User findById() {
//        return findById(null);
//    }

//    @Override
    public  User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public User registerUser(String username, String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
      User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole("USER");
//        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public  List<User> findAll(){

        return userRepository.findAll();

    }
    public User saveUser( User user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setRole("USER");
        return userRepository.save(newUser);

    }

    public User updateUser(User user, Long id) {
        User existingUser =findById(id );
        existingUser.setUsername(user.getUsername());
//        existingUser.setPassword(user.getPassword());
//        existingUser.setRole(user.getRole());
//
        return userRepository.save(existingUser);
    }

    public void deleteUser( Long id) {
        User existingUser =findById(id);
        userRepository.delete(existingUser);
    }
}
