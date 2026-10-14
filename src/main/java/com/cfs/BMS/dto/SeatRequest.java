package com.cfs.BMS.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatRequest {

    private String seatNumber;
    private String row;
    private String col;
    private Integer seatType;
    private Long screenId;

}
