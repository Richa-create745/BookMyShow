package com.cfs.BMS.controller;


import com.cfs.BMS.dto.BookingRequest;
import com.cfs.BMS.entity.Booking;
import com.cfs.BMS.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;


    //to create booking
    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequest request){
        return ResponseEntity.ok(bookingService.createBooking(request));

    }


    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id){
          return ResponseEntity.ok(bookingService.getBookingById(id));

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getBookingByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(bookingService.getBookingByUser(userId));

    }


    //study it deeply
    @PutMapping("/{id}/cancel")
    public ResponseEntity<Booking> cancelBooking(@PathVariable Long id){
        return ResponseEntity.ok(bookingService.cancelBooking(id));

    }


    //important

    @GetMapping("/show/{showId}/available-seats")
    public ResponseEntity<List<com.cfs.BMS.entity.Seat>> getAvailableSeats(
            @PathVariable Long showId) {
        return ResponseEntity.ok(bookingService.getAvailableSeats(showId));
    }


}

