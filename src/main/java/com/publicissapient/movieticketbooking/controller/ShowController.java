package com.publicissapient.movieticketbooking.controller;

import com.publicissapient.movieticketbooking.entity.Show;
import com.publicissapient.movieticketbooking.entity.Theater;
import com.publicissapient.movieticketbooking.service.ShowService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Data
@RequestMapping("/api/show")
@RestController
public class ShowController {
    @Autowired
    ShowService showService;

    @PostMapping("/")
    public ResponseEntity<String> addShow(@RequestBody Show show){
        Show newShow = showService.create(show);
        return  ResponseEntity.status(201).body("Created " + newShow.getShowId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Show> getShow(@PathVariable String id){
        Show t = showService.findById(UUID.fromString(id));
        if(t == null){
            return  ResponseEntity.status(404).body(null);
        }else {
            return  ResponseEntity.ok().body(t);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShow(@PathVariable String id){
        Show t = showService.deleteById(UUID.fromString(id));
        if(t== null){
            return  ResponseEntity.status(404).body(id);
        } else {
            return ResponseEntity.ok().body(id);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Show> updateShow(@PathVariable String id, @RequestBody Show user){
        Show t =  showService.updateById(UUID.fromString(id),user);
        if(t== null){
            return  ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.ok().body(t);
        }

    }

    @GetMapping("/")
    public List<Show> getAllShows(){
        return  showService.findAll();
    }

}
