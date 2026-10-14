package com.cfs.BMS.service;


import com.cfs.BMS.dto.SeatRequest;
import com.cfs.BMS.entity.Screen;
import com.cfs.BMS.entity.Seat;
import com.cfs.BMS.enums.seatType;
import com.cfs.BMS.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatService {

     private final SeatRepository seatRepository;
     private final ScreenService screenService;

     //addseat-->H.Work
     public Seat addSeat(SeatRequest request) {

         Screen screen = screenService.getScreenById(request.getScreenId());

         Seat seat = Seat.builder()
                 .seatNumber(request.getSeatNumber())
                 .row(request.getRow())
                 .col(request.getCol())
                 .seatType(seatType.values()[request.getSeatType()])
                 .screen(screen)
                 .build();

         return seatRepository.save(seat);
     }




    //by screenId
    public List<Seat> getSeatByScreenId(Long screenId){
        return seatRepository.findByScreenId(screenId);
    }

    public Seat getSeatById(Long id)
    {
        return seatRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Seat not found by this id: "+id));
    }



}
