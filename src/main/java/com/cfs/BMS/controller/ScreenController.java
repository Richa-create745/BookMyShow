package com.cfs.BMS.controller;


import com.cfs.BMS.dto.ScreenRequest;
import com.cfs.BMS.entity.Screen;
import com.cfs.BMS.entity.Seat;
import com.cfs.BMS.service.ScreenService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.IdGeneratorType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/screens")
@RequiredArgsConstructor
public class ScreenController {

    private final ScreenService screenService;


    //add scrren-->H.W
    @PostMapping
    public ResponseEntity<Screen> addScreen(
            @RequestBody ScreenRequest request) {

        Screen screen = screenService.addScreen(
                request.getName(),
                request.getTotalSeats(),
                request.getTheaterId()
        );

        return ResponseEntity.ok(screen);
    }

    @GetMapping
    public ResponseEntity<List<Screen>> getAllScreen()
    {
        return ResponseEntity.ok(screenService.getAllScreen());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Screen> getScreenById(@PathVariable Long Id){
        return ResponseEntity.ok(screenService.getScreenById(Id));

    }

    @GetMapping("/theater/{theaterId}")
    public ResponseEntity<List<Screen>> getScreenByTheaterId(@PathVariable Long theaterId){
        return ResponseEntity.ok(screenService.getScreenByTheater(theaterId));
    }
}
