package com.cfs.BMS.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.lang.model.element.NestingKind;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TheaterRequest {


    private String name;
    private String address;
    private Long cityId;


}
