package com.cfs.BMS.repository;

import com.cfs.BMS.entity.Seat;
import com.cfs.BMS.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat,Long>{

    //code
    List<Seat> findByScreenId(Long screenId );



}
