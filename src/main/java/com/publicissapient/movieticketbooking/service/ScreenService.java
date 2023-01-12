package com.publicissapient.movieticketbooking.service;


import com.publicissapient.movieticketbooking.entity.Screen;
import com.publicissapient.movieticketbooking.entity.Screen;
import com.publicissapient.movieticketbooking.repository.ScreenRepository;
import com.publicissapient.movieticketbooking.repository.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ScreenService {

    @Autowired
    private ScreenRepository screenRepository;

    public Screen create(Screen screen){
        Screen theaterExists = screenRepository.findByName(screen.getName());
        if(theaterExists!=null){
            return null;
        }else{
            return screenRepository.save(screen);
        }
    }

    public Screen findById(UUID uuid){
        boolean theaterExists = screenRepository.existsById(uuid);
        if(theaterExists){
            return screenRepository.findById(uuid).get();
        }else{
            return null;
        }
    }

    public List<Screen> findAll(){
        return screenRepository.findAll();
    }

    public Screen deleteById(UUID uuid){
        Optional<Screen> theater = screenRepository.findById(uuid);
        Screen result;

        if(theater.isPresent()){
            screenRepository.deleteById(uuid);
            result = theater.get();
        } else {
            result = null;
        }
        return result;
    }

    public Screen updateById(UUID uuid,Screen screen){
        if(screenRepository.findByScreenId(uuid)!=null){
            Screen updatedScreen = screenRepository.findByScreenId(uuid);
//            updatedScreen.setScreenId(updatedScreen.getScreenId());
//            updatedScreen.setTheaterId(screen.getTheaterId());
            updatedScreen.setName(screen.getName());
            screenRepository.save(updatedScreen);
            return screen;
        } else {
            return null;
        }

    }
}
