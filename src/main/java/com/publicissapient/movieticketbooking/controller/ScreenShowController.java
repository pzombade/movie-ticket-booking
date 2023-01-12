package com.publicissapient.movieticketbooking.controller;

import com.publicissapient.movieticketbooking.entity.ScreenShow;
import com.publicissapient.movieticketbooking.service.ScreenShowService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Data
@RequestMapping("/api/screenshow")
@RestController
public class ScreenShowController {

    @Autowired
    ScreenShowService screenShowService;

    @PostMapping("/")
    public ResponseEntity<String> addScreen(@RequestBody ScreenShow screen){
        ScreenShow newScreen = screenShowService.create(screen);
//        if(newScreen == null){
//            return  ResponseEntity.status(400).body("Name exists :" + screen.getName());
//        }else {
//            return  ResponseEntity.status(201).body("Created " + newScreen.getScreenId());
//        }

        return  ResponseEntity.status(201).body("Created " + newScreen.getScreenId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScreenShow> getScreen(@PathVariable String id){
        ScreenShow t = screenShowService.findById(UUID.fromString(id));
        if(t == null){
            return  ResponseEntity.status(404).body(null);
        }else {
            return  ResponseEntity.ok().body(t);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteScreen(@PathVariable String id){
        ScreenShow t = screenShowService.deleteById(UUID.fromString(id));
        if(t== null){
         return  ResponseEntity.status(404).body(id);
        } else {
            return ResponseEntity.ok().body(id);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScreenShow> updateScreen(@PathVariable String id, @RequestBody ScreenShow user){
        ScreenShow t =  screenShowService.updateById(UUID.fromString(id),user);
        if(t== null){
            return  ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.ok().body(t);
        }

    }

    @GetMapping("/")
    public List<ScreenShow> getAllScreens(){
        return  screenShowService.findAll();
    }
}
