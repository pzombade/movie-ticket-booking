package com.publicissapient.movieticketbooking.service;


import com.publicissapient.movieticketbooking.entity.Booking;
import com.publicissapient.movieticketbooking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking create(Booking booking){
        return bookingRepository.save(booking);
    }

    public Booking findById(UUID uuid){
        boolean theaterExists = bookingRepository.existsById(uuid);
        if(theaterExists){
            return bookingRepository.findById(uuid).get();
        }else{
            return null;
        }
    }

    public List<Booking> findAll(){
        return bookingRepository.findAll();
    }

    public Booking deleteById(UUID uuid){
        Optional<Booking> theater = bookingRepository.findById(uuid);
        Booking result;

        if(theater.isPresent()){
            bookingRepository.deleteById(uuid);
            result = theater.get();
        } else {
            result = null;
        }
        return result;
    }

    public Booking updateById(UUID uuid,Booking booking){
        if(bookingRepository.findById(uuid).isPresent()){
            booking.setBookingId(uuid);
            bookingRepository.save(booking);
            return booking;
        } else {
            return null;
        }
    }
}
