package com.publicissapient.movieticketbooking.service;


import com.publicissapient.movieticketbooking.entity.ScreenShow;

import com.publicissapient.movieticketbooking.repository.ScreenShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ScreenShowService {

    @Autowired
    private ScreenShowRepository screenShowRepository;

    public ScreenShow create(ScreenShow show){
//        Optional<ScreenShow> theaterExists = screenShowRepository.findById(show.getScreenShowId());
//        if(theaterExists.isPresent()){
//            return null;
//        }else{
//            return screenShowRepository.save(show);
//        }
        return screenShowRepository.save(show);
    }

    public ScreenShow findById(UUID uuid){
        boolean theaterExists = screenShowRepository.existsById(uuid);
        if(theaterExists){
            return screenShowRepository.findById(uuid).get();
        }else{
            return null;
        }
    }

    public List<ScreenShow> findAll(){
        return screenShowRepository.findAll();
    }

    public ScreenShow deleteById(UUID uuid){
        Optional<ScreenShow> theater = screenShowRepository.findById(uuid);
        ScreenShow result;

        if(theater.isPresent()){
            screenShowRepository.deleteById(uuid);
            result = theater.get();
        } else {
            result = null;
        }
        return result;
    }

    public ScreenShow updateById(UUID uuid,ScreenShow show){
        if(screenShowRepository.findById(uuid).isPresent()){
            show.setShowId(uuid);
            screenShowRepository.save(show);
            return show;
        } else {
            return null;
        }
    }
}
