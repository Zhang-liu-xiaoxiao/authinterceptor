package com.example.demo.controller;

import com.example.demo.nnotation.AuthControl;
import com.example.demo.Enum.AuthLevel;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @AuthControl(AuthLevel.ROOT)
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @AuthControl(AuthLevel.ADMIN)
    public User findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping
    @AuthControl(AuthLevel.ADMIN)
    public int create(@RequestBody User user) {
        return userService.insert(user);
    }

    @PutMapping
    @AuthControl(AuthLevel.ADMIN)
    public int update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    @AuthControl(AuthLevel.ADMIN)
    public int delete(@PathVariable Integer id) {
        return userService.delete(id);
    }
}
