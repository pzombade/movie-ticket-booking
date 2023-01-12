package com.publicissapient.movieticketbooking.service;


import com.publicissapient.movieticketbooking.entity.Show;
import com.publicissapient.movieticketbooking.entity.Show;
import com.publicissapient.movieticketbooking.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    public Show create(Show show){
        Optional<Show> theaterExists = showRepository.findById(show.getShowId());
        if(theaterExists.isPresent()){
            return null;
        }else{
            return showRepository.save(show);
        }
    }

    public Show findById(UUID uuid){
        boolean theaterExists = showRepository.existsById(uuid);
        if(theaterExists){
            return showRepository.findById(uuid).get();
        }else{
            return null;
        }
    }

    public List<Show> findAll(){
        return showRepository.findAll();
    }

    public Show deleteById(UUID uuid){
        Optional<Show> theater = showRepository.findById(uuid);
        Show result;

        if(theater.isPresent()){
            showRepository.deleteById(uuid);
            result = theater.get();
        } else {
            result = null;
        }
        return result;
    }

    public Show updateById(UUID uuid,Show show){
        if(showRepository.findById(uuid).isPresent()){
            show.setShowId(uuid);

            showRepository.save(show);
            return show;
        } else {
            return null;
        }

    }
}
