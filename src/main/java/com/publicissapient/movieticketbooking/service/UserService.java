package com.publicissapient.movieticketbooking.service;


import com.publicissapient.movieticketbooking.exception.UserNotFoundException;
import com.publicissapient.movieticketbooking.dto.UserDto;
import com.publicissapient.movieticketbooking.entity.User;
import com.publicissapient.movieticketbooking.exception.UserNotFoundException;
import com.publicissapient.movieticketbooking.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager em;

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

    public List getUpcomingShows(String userName){
//        String query =
//               "select   screen_show.*, sh.*, sc.*, t.* from public.screen_show inner join show sh on sh.show_id = screen_show.show_id inner join screen sc on sc.screen_id = screen_show.screen_id inner join theater t on t.theater_id = sc.theater_id where screen_show.show_date_time > NOW() and t.zip = '111111' and sh.title not like 'Avtaar2' ;"; // and screen_show.show_date_time >= '2023-01-20'::date AND screen_show.show_date_time < ('2023-01-20'::date + '1 day'::interval)
        String query =
                "select u.user_name, ss.show_date_time, sh.title , t.name as theatername,sc.name as screenname, b.seats_booked from public.screen_show ss inner join show sh on sh.show_id = ss.show_id inner join screen sc on sc.screen_id = ss.screen_id inner join theater t on t.theater_id = sc.theater_id inner join booking b on b.screen_show_id = ss.screen_show_id inner join user_entity u on u.id = b.user_id where u.user_name like :userName"; // and screen_show.show_date_time >= '2023-01-20'::date AND screen_show.show_date_time < ('2023-01-20'::date + '1 day'::interval)

        Query q = em.createNativeQuery(query);
        q.setParameter("userName",userName);
        List l = q.getResultList();


        List result = new ArrayList();
        for(Object p:l){
            Map<String,String> map = new HashMap<>();
            map.put("user_name",((Object[])p)[0].toString() );
            map.put("dateTime",((Object[])p)[1].toString() );
            map.put("title",((Object[])p)[2].toString() );
            map.put("theatername",((Object[])p)[3].toString() );
            map.put("screenname",((Object[])p)[4].toString() );
            map.put("seats_booked",((Object[])p)[5].toString() );

            result.add(map);
        }
        log.info("Upcoming",result);
        return result;
    }
}
