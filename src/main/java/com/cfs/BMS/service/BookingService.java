package com.cfs.BMS.service;

import com.cfs.BMS.dto.BookingRequest;
import com.cfs.BMS.entity.Booking;
import com.cfs.BMS.entity.Seat;
import com.cfs.BMS.entity.Show;
import com.cfs.BMS.entity.User;
import com.cfs.BMS.enums.BookingStatus;
import com.cfs.BMS.repository.BookingRepository;
import com.cfs.BMS.repository.SeatRepository;
import com.cfs.BMS.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final SeatRepository seatRepository;
    private final UserService userService;
    private final ShowService showService;

    public Booking createBooking(BookingRequest request)
    {
        //user dhundo jo booking kr raha h
       User user=userService.getUserById(request.getUserId());

       Show show=showService.getShowById(request.getShowId());

        //check if any of the requested seat are already booked
        List<Long> alreadyBookedSeats=bookingRepository.findBookedSeatIdsByShowId(show.getId());
         for(Long seatId:request.getSeatIds()){
             if(alreadyBookedSeats.contains(seatId))
             {
                 throw new RuntimeException("seat with id: "+seatId+" is already booked");

             }
         }

           List<Seat> seats=seatRepository.findAllById(request.getSeatIds());
            if(seats.size()!=request.getSeatIds().size()){
             throw new RuntimeException("some seats are Invalid");
            }

            double totalPrice=seats.size()*show.getTicketPrice();
            Booking booking=Booking.builder()
                    .user(user)
                    .show(show)
                    .seats(seats)
                    .totalPrice(totalPrice)
                    .status(BookingStatus.CONFIRMED)
                    .build();

            return bookingRepository.save(booking);

    }

    //to get booking by id

    public Booking getBookingById(Long id)
    {
         return bookingRepository.findById(id)
                 .orElseThrow(()->new RuntimeException("Booking not found by id: "+id));
    }

// to find booking by userId
     public List<Booking> getBookingByUser(Long userId){
        return bookingRepository.findByUserId(userId);

     }

     //to cancel Booking
    @Transactional
    public Booking cancelBooking(Long bookingId )
    {
        Booking booking=getBookingById(bookingId);
        booking.setStatus(BookingStatus.CANCELLED);
        return bookingRepository.save(booking);

    }

    //to get available seats
    public List<Seat> getAvailableSeats(Long showId){
        Show show=showService.getShowById(showId);
        List<Seat> allSeats=seatRepository.findByScreenId(show.getScreen().getId());
        List<Long> bookingSeatIds=bookingRepository.findBookedSeatIdsByShowId(showId);
        return allSeats.stream()
                .filter(seat -> !bookingSeatIds.contains(seat.getId()))
                .toList();
    }


}
