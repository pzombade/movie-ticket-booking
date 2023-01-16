package com.publicissapient.movieticketbooking;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class MovieTicketBookingApplicationTests {

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Test
    void test() {
        System.out.println("Hello World!");

        String encoded = passwordEncoder.encode("12345");
        System.out.println("encoded: " + encoded);

        boolean matches = passwordEncoder.matches("12345", encoded);
        System.out.println("matches: " + matches);


    }

}
