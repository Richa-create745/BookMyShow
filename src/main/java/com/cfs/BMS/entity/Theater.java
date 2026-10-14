package com.cfs.BMS.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.query.sqm.spi.CacheabilityInfluencers;

@Entity
@Table(name="theaters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Theater {

  // now cities will be having theatre

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String address;

    @ManyToOne
    @JoinColumn(name="city_id",nullable = false)
    private City city;


}
