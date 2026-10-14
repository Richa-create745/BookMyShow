package com.cfs.BMS.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="screens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Screen {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; //AUDI-1, AUDI-2, AUDI-3

    private Integer totalSeats;

    @ManyToOne
    @JoinColumn(name="theater_id", nullable = false)
    private Theater theater;



}
