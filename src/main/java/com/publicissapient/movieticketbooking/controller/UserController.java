package com.publicissapient.movieticketbooking.controller;


import com.publicissapient.movieticketbooking.dto.UserDto;
import com.publicissapient.movieticketbooking.entity.User;
import com.publicissapient.movieticketbooking.exception.UserNotFoundException;
import com.publicissapient.movieticketbooking.service.UserService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Data
@RequestMapping("/api/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/")
    public User addUser(@RequestBody @Valid UserDto userDto){
        User newUser = userService.create(userDto);
        return  newUser;
    }


    @PostMapping("/login")
    public boolean loginSucceeded(@RequestBody User user) throws UserNotFoundException {
        return  userService.loginSucceeded(user.getUserName(),user.getHashedPassword());
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) throws UserNotFoundException {
        return  userService.findById(UUID.fromString(id));
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id){
        userService.deleteById(UUID.fromString(id));
        return "Deleted "+ id;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user){
        return  userService.updateById(UUID.fromString(id),user);

//        return "Deleted "+ id;
    }

    @GetMapping("/")
    public List<User> getAllUsers(){
        return  userService.findAll();
    }

}
