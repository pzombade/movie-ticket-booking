package com.publicissapient.movieticketbooking.controller;

import com.publicissapient.movieticketbooking.entity.Screen;
import com.publicissapient.movieticketbooking.entity.Screen;
import com.publicissapient.movieticketbooking.service.ScreenService;
import com.publicissapient.movieticketbooking.service.ScreenService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Data
@RequestMapping("/api/screen")
@RestController
public class ScreenController {

    @Autowired
    ScreenService screenService;

    @PostMapping("/")
    public ResponseEntity<String> addScreen(@RequestBody Screen screen){
        Screen newScreen = screenService.create(screen);
        if(newScreen == null){
            return  ResponseEntity.status(400).body("Name exists :" + screen.getName());
        }else {
            return  ResponseEntity.status(201).body("Created " + newScreen.getScreenId());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Screen> getScreen(@PathVariable String id){
        Screen t = screenService.findById(UUID.fromString(id));
        if(t == null){
            return  ResponseEntity.status(404).body(null);
        }else {
            return  ResponseEntity.ok().body(t);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteScreen(@PathVariable String id){
        Screen t = screenService.deleteById(UUID.fromString(id));
        if(t== null){
         return  ResponseEntity.status(404).body(id);
        } else {
            return ResponseEntity.ok().body(id);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Screen> updateScreen(@PathVariable String id, @RequestBody Screen user){
        Screen t =  screenService.updateById(UUID.fromString(id),user);
        if(t== null){
            return  ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.ok().body(t);
        }

    }

    @GetMapping("/")
    public List<Screen> getAllScreens(){
        return  screenService.findAll();
    }
}
