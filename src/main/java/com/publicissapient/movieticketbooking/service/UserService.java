package com.publicissapient.movieticketbooking.service;


import com.publicissapient.movieticketbooking.entity.User;
import com.publicissapient.movieticketbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user){
        return userRepository.save(user);
    }

    public User findById(UUID uuid){
        return userRepository.findById(uuid).orElseThrow();
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public UUID deleteById(UUID uuid){
         userRepository.deleteById(uuid);
         return uuid;
    }

    public User updateById(UUID uuid,User user){
        User updatedUser = userRepository.findById(uuid).orElseThrow();
        updatedUser.setUserName(user.getUserName());
        updatedUser.setEmailId(user.getEmailId());
        updatedUser.setPhone(user.getPhone());
        updatedUser.setZip(user.getZip());
        updatedUser.setHashedPassword(user.getHashedPassword());
        userRepository.save(updatedUser);
        return updatedUser;
    }
}
