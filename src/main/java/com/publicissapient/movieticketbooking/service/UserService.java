package com.publicissapient.movieticketbooking.service;


import com.publicissapient.movieticketbooking.UserNotFoundException;
import com.publicissapient.movieticketbooking.dto.UserDto;
import com.publicissapient.movieticketbooking.entity.User;
import com.publicissapient.movieticketbooking.exception.UserNotFoundException;
import com.publicissapient.movieticketbooking.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User create(UserDto userDto){
        User user = User.builder()
                .userName(userDto.getUserName())
                .emailId(userDto.getEmailId())
                .phone(userDto.getPhone())
                .hashedPassword(userDto.getHashedPassword()) // TODO: Hash the password
                .zip(userDto.getZip())
                .build();
        return userRepository.save(user);
    }

    public User findById(UUID uuid) throws UserNotFoundException {
        return userRepository.findById(uuid).orElseThrow(()->new UserNotFoundException(uuid.toString()));
    }
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User create(User user){
        user.setHashedPassword(passwordEncoder.encode(user.getHashedPassword()));
        return userRepository.save(user);
    }

    public boolean loginSucceeded(String userName, String password) throws UserNotFoundException {
        User fromDB = userRepository.findByUserName(userName);

        if(fromDB == null){
            throw new UserNotFoundException("Credentials did not match for the user: "+userName);
        }

        boolean result =  passwordEncoder.matches(password, fromDB.getHashedPassword());
        log.info("result:"+result+" password:"+password+", fromDB.getHashedPassword():"+fromDB.getHashedPassword());
        return result;
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
        log.info("Updating user " + user);
        User updatedUser = userRepository.findById(uuid).orElseThrow();
        updatedUser.setUserName(user.getUserName());
        updatedUser.setEmailId(user.getEmailId());
        updatedUser.setPhone(user.getPhone());
        updatedUser.setZip(user.getZip());
        updatedUser.setHashedPassword(passwordEncoder.encode(user.getHashedPassword()));
        userRepository.save(updatedUser);
        return updatedUser;
    }
}
