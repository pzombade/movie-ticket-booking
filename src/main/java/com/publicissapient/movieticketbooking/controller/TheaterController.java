package com.publicissapient.movieticketbooking.controller;

import com.publicissapient.movieticketbooking.entity.Theater;
import com.publicissapient.movieticketbooking.service.TheaterService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Data
@RequestMapping("/api/theater")
@RestController
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @PostMapping("/")
    public ResponseEntity<String> addTheater(@RequestBody Theater theater){
        Theater newTheater = theaterService.create(theater);
        if(newTheater == null){
            return  ResponseEntity.status(400).body("Email id exists :" + theater.getEmailId());
        }else {
            return  ResponseEntity.status(201).body("Created " + newTheater.getTheaterId());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Theater> getTheater(@PathVariable String id){
        Theater t = theaterService.findById(UUID.fromString(id));
        if(t == null){
            return  ResponseEntity.status(404).body(null);
        }else {
            return  ResponseEntity.ok().body(t);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTheater(@PathVariable String id){
        Theater t = theaterService.deleteById(UUID.fromString(id));
        if(t== null){
         return  ResponseEntity.status(404).body(id);
        } else {
            return ResponseEntity.ok().body(id);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Theater> updateTheater(@PathVariable String id, @RequestBody Theater user){
        Theater t =  theaterService.updateById(UUID.fromString(id),user);
        if(t== null){
            return  ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.ok().body(t);
        }

    }

    @GetMapping("/")
    public List<Theater> getAllTheaters(){
        return  theaterService.findAll();
    }
}
