package com.publicissapient.movieticketbooking.service;


import com.publicissapient.movieticketbooking.entity.Theater;
import com.publicissapient.movieticketbooking.entity.User;
import com.publicissapient.movieticketbooking.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    public Theater create(Theater theater){
        Theater theaterExists = theaterRepository.findByEmailId(theater.getEmailId());
        if(theaterExists!=null){
            return null;
        }else{
            return theaterRepository.save(theater);
        }
    }

    public Theater findById(UUID uuid){
        boolean theaterExists = theaterRepository.existsById(uuid);
        if(theaterExists){
            return theaterRepository.findById(uuid).get();
        }else{
            return null;
        }
    }

    public List<Theater> findAll(){
        return theaterRepository.findAll();
    }

    public Theater deleteById(UUID uuid){
        Optional<Theater> theater = theaterRepository.findById(uuid);
        Theater result;

        if(theater.isPresent()){
            theaterRepository.deleteById(uuid);
            result = theater.get();
        } else {
            result = null;
        }
        return result;
    }

    public Theater updateById(UUID uuid,Theater theater){
        Optional<Theater> updatedTheater = theaterRepository.findById(uuid);

        if(updatedTheater.isPresent()){
//            updatedTheater.setName(theater.getName());
//            updatedTheater.setEmailId(theater.getEmailId());
//            updatedTheater.setPhone(theater.getPhone());
//            updatedTheater.setZip(theater.getZip());
//            updatedTheater.setHashedPassword(theater.getHashedPassword());
            theaterRepository.save(theater);
            return  theater;
        } else {
            return  null;
        }

    }
}
