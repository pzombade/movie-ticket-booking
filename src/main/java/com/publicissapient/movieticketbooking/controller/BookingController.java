package com.publicissapient.movieticketbooking.controller;

import com.publicissapient.movieticketbooking.entity.Booking;
import com.publicissapient.movieticketbooking.service.BookingService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Data
@RequestMapping("/api/booking")
@RestController
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/")
    public ResponseEntity<String> addBooking(@RequestBody Booking booking){
        Booking newBooking = bookingService.create(booking);
        return  ResponseEntity.status(201).body("Created " + newBooking.getBookingId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable String id){
        Booking t = bookingService.findById(UUID.fromString(id));
        if(t == null){
            return  ResponseEntity.status(404).body(null);
        }else {
            return  ResponseEntity.ok().body(t);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable String id){
        Booking t = bookingService.deleteById(UUID.fromString(id));
        if(t== null){
         return  ResponseEntity.status(404).body(id);
        } else {
            return ResponseEntity.ok().body(id);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable String id, @RequestBody Booking booking){
        Booking t =  bookingService.updateById(UUID.fromString(id),booking);
        if(t== null){
            return  ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.ok().body(t);
        }
    }

    @GetMapping("/")
    public List<Booking> getAllBookings(){
        return  bookingService.findAll();
    }
}
