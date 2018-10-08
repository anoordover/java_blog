package net.noordover.springboot.blog.controllers;

import java.util.Arrays;
import java.util.List;
import net.noordover.springboot.blog.entities.Role;
import net.noordover.springboot.blog.entities.User;
import net.noordover.springboot.blog.pojos.UserRegistration;
import net.noordover.springboot.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
        @Autowired
        private UserService userService;


        @PostMapping("/register")
        @ResponseStatus(HttpStatus.CREATED)
        public String register(@RequestBody UserRegistration userRegistration) {
                if (!userRegistration.getPassword().equals(userRegistration.getPasswordConfirmation()))
                        return "Passwords do not match";
                if (userService.getUser(userRegistration.getUsername()) != null)
                        return "User already exists";
                userService.save(new User(userRegistration.getUsername(),
                                          userRegistration.getPassword(),
                                          Arrays.asList(new Role("USER")),
                                          true));
                return "User created";
        }

        @GetMapping("/users")
        public List<User> getAllUsers() {
                return userService.getAllUsers();
        }
}
