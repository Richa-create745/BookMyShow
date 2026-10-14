package com.cfs.BMS.service;


import com.cfs.BMS.entity.Screen;
import com.cfs.BMS.entity.Theater;
import com.cfs.BMS.repository.ScreenRepository;
import com.cfs.BMS.repository.TheaterRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.metamodel.internal.RuntimeMetamodelsImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScreenService {

    private final ScreenRepository screenRepository;
    private final TheaterService theaterService;

 //======================================================
    //write by your own a method to addScreen
//=======================================================
 public Screen addScreen(String name, Integer totalSeats, Long theaterId) {

     Theater theater = theaterService.getTheaterById(theaterId);

     Screen screen = Screen.builder()
             .name(name)
             .totalSeats(totalSeats)
             .theater(theater)
             .build();

     return screenRepository.save(screen);
 }

    public List<Screen> getAllScreen()
    {
        return screenRepository.findAll();
    }


    public Screen getScreenById(Long id)
    {
        return screenRepository.findById(id)
                .orElseThrow(()->new RuntimeException("screen not found by the id: "+id));

    }

    public List<Screen> getScreenByTheater(Long theaterId){
        return screenRepository.findByTheaterId(theaterId);
    }


}
