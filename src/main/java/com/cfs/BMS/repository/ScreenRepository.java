package com.cfs.BMS.repository;

import com.cfs.BMS.entity.Screen;
import com.cfs.BMS.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScreenRepository extends JpaRepository<Screen,Long>{

    //screen kaha lgti h  ttheater me so theaterid
   List<Screen> findByTheaterId(Long theaterId);// screen ko kse find krenge?=> theater id k through


}
