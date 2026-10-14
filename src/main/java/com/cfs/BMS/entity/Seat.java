package com.cfs.BMS.entity;


import com.cfs.BMS.enums.seatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="seats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String seatNumber;

    @Column(name="seat_row")
    private String row; //A , B, C ,K , H ,,, ETC


    @Column(name="seat_col")
    private String col; // IN INTEGER 1,2,3,4...etc

    @Enumerated(EnumType.STRING)
    private seatType seatType; //REGULAR


    @ManyToOne
    @JoinColumn(name = "screen_id",nullable = false)
    private Screen screen;



}
