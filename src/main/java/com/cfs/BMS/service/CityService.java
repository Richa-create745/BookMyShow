package com.cfs.BMS.service;


import com.cfs.BMS.entity.City;
import com.cfs.BMS.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    //to add city
    public City addCity(City city)
    {
        return cityRepository.save(city);

    }

    //to get all cities
    public List<City> getAllCities()
    {
        return cityRepository.findAll();
    }

    //to get city by id n if not found with that id then exception
    public City getCityById(Long id)
    {
        return cityRepository.findById(id)
                .orElseThrow(()->new RuntimeException("city not found with id: "+ id));
    }






}
