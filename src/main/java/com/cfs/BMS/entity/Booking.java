package com.cfs.BMS.entity;

import com.cfs.BMS.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name="bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //booking kon karega =>user
    //many booking can be done by one user
    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private  User user;


    //booking for show
    //many booking can be there for just one show
    @ManyToOne
    @JoinColumn(name="show_id", nullable = false)
    private Show show;

    @ManyToMany
    @JoinTable(
            name="booking_seats",
            joinColumns=@JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name="seat_id")
    )
    private List<Seat> seats;

    private Double totalPrice;

    // now booking ka status btana hai
    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    private LocalDateTime bookedAt;


    //study about this portion..
    @PrePersist
    private  void onCreate()
    {
        this.bookedAt=LocalDateTime.now();
        if(this.status==null){
             this.status=BookingStatus.CONFIRMED;
        }
    }

}
