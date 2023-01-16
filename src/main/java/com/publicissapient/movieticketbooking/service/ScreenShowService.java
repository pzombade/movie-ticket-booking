package com.publicissapient.movieticketbooking.service;


import com.publicissapient.movieticketbooking.entity.ScreenShow;
import com.publicissapient.movieticketbooking.repository.ScreenShowRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class ScreenShowService {


    @Autowired
    private ScreenShowRepository screenShowRepository;


    @PersistenceContext
    private EntityManager em;

    public ScreenShow create(ScreenShow show) {
//        Optional<ScreenShow> theaterExists = screenShowRepository.findById(show.getScreenShowId());
//        if(theaterExists.isPresent()){
//            return null;
//        }else{
//            return screenShowRepository.save(show);
//        }
        return screenShowRepository.save(show);
    }

    public ScreenShow findById(UUID uuid) {
        boolean theaterExists = screenShowRepository.existsById(uuid);
        if (theaterExists) {
            return screenShowRepository.findById(uuid).get();
        } else {
            return null;
        }
    }

    public List<ScreenShow> findAll() {
        return screenShowRepository.findAll();
    }

    public ScreenShow deleteById(UUID uuid) {
        Optional<ScreenShow> theater = screenShowRepository.findById(uuid);
        ScreenShow result;

        if (theater.isPresent()) {
            screenShowRepository.deleteById(uuid);
            result = theater.get();
        } else {
            result = null;
        }
        return result;
    }

    public ScreenShow updateById(UUID uuid, ScreenShow show) {
        if (screenShowRepository.findById(uuid).isPresent()) {
            show.setShowId(uuid);
            screenShowRepository.save(show);
            return show;
        } else {
            return null;
        }
    }

    public List getRunningShows(String title, String zip) {
//        String query =
//               "select   screen_show.*, sh.*, sc.*, t.* from public.screen_show inner join show sh on sh.show_id = screen_show.show_id inner join screen sc on sc.screen_id = screen_show.screen_id inner join theater t on t.theater_id = sc.theater_id where screen_show.show_date_time > NOW() and t.zip = '111111' and sh.title not like 'Avtaar2' ;"; // and screen_show.show_date_time >= '2023-01-20'::date AND screen_show.show_date_time < ('2023-01-20'::date + '1 day'::interval)
        String query =
                "select t.name, screen_show.show_date_time from public.screen_show inner join show sh on sh.show_id = screen_show.show_id inner join screen sc on sc.screen_id = screen_show.screen_id inner join theater t on t.theater_id = sc.theater_id where screen_show.show_date_time > NOW() and t.zip = :zip and sh.title like :title"; // and screen_show.show_date_time >= '2023-01-20'::date AND screen_show.show_date_time < ('2023-01-20'::date + '1 day'::interval)

        Query q = em.createNativeQuery(query);
        q.setParameter("title", title);
        q.setParameter("zip", zip);
        List l = q.getResultList();


        List result = new ArrayList();
        for (Object p : l) {
            Map<String, String> map = new HashMap<>();
            map.put("name", ((Object[]) p)[0].toString());
            map.put("dateTime", ((Object[]) p)[1].toString());
            log.info("Theater {} at {}", ((Object[]) p)[0], ((Object[]) p)[1]);
            result.add(map);
        }

        return result;
    }

}
