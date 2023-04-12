package com.springbootbackendapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootbackendapp.dto.reqestDto.CityRequestDto;
import com.springbootbackendapp.exception.ResourceNotFoundException;
import com.springbootbackendapp.model.City;
import com.springbootbackendapp.repository.CityRepository;
import com.springbootbackendapp.service.CityService;

import jakarta.transaction.Transactional;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;

	@Override
	public City addCity(CityRequestDto cityRequestDto) {
		City city = new City();
		city.setName(cityRequestDto.getName());
		return cityRepository.save(city);
	}

	@Override
	public List<City> getCities() {
		List<City> cities = new ArrayList<>();
		cityRepository.findAll().forEach(cities::add);
		return cities;
	}

	@Override
	public City getCity(Long cityId) {
		return cityRepository.findById(cityId)
				.orElseThrow(() -> new ResourceNotFoundException("City", "city id", cityId));
	}

	@Override
	public City deleteCity(Long cityId) {
		City city = getCity(cityId);
		cityRepository.delete(city);
		return city;
	}

	@Transactional
	@Override
	public City editCity(Long cityId, CityRequestDto cityRequestDto) {
		City cityToEdit = getCity(cityId);
		cityToEdit.setName(cityRequestDto.getName());
		return cityToEdit;
	}

}
