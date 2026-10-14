package com.cfs.BMS.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="users")
@Getter @Setter // if i wwwant ki runtime pe automatically steer getter ban jaye
@NoArgsConstructor @AllArgsConstructor  //for automatic construction of default n parametrised constructor
@Builder // study about it...

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) //mtlb name cannot be nullabe , DB me vaps sb nahi bnaega,  sbkuch yahi se uodate n validate hoga
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;


    private String phone;

    private LocalDateTime createdAt;

    @PrePersist  //study about it too
    protected  void onCreate()
    {
        this.createdAt=LocalDateTime.now();
    }


}
