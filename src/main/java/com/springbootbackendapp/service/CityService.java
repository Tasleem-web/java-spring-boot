package com.springbootbackendapp.service;

import java.util.List;

import com.springbootbackendapp.dto.reqestDto.CityRequestDto;
import com.springbootbackendapp.model.City;

public interface CityService {

	public City addCity(CityRequestDto cityRequestDto);

	public List<City> getCities();

	public City getCity(Long cityId);

	public City deleteCity(Long cityId);

	public City editCity(Long cityId, CityRequestDto cityRequestDto);

}
