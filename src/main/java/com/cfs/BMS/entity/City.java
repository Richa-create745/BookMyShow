package com.cfs.BMS.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="cities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class City {
    //city=>user may belong to this city

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @Column(nullable = false,unique = true)
     private String name;

     private String state;

}
