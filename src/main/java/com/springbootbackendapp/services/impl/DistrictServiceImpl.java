package com.springbootbackendapp.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootbackendapp.exception.ResourceNotFoundException;
import com.springbootbackendapp.model.District;
import com.springbootbackendapp.repository.DistrictRepository;
import com.springbootbackendapp.services.DistrictService;

@Service
public class DistrictServiceImpl implements DistrictService {

	@Autowired
	private DistrictRepository districtRepository;

	@Override
	public District addDistrict(District district) {
		return districtRepository.save(district);
	}

	@Override
	public Collection<District> addMultipleDistrict(Collection<District> districts) {
		List<District> districtEntities = new ArrayList<>();

		for (District district : districts) {
			districtEntities.add(district);
		}

		Collection<District> persistedDistrict = districtRepository.saveAll(districtEntities);
		return persistedDistrict;
	}

	@Override
	public District updateDistrict(District district, Long id) {
		System.out.println(district);
		System.out.println(id);
		District existingDistrict = districtRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("District", "District Id", id));
		existingDistrict.setDistrictId(district.getDistrictId());
		existingDistrict.setName(district.getName());
		districtRepository.save(existingDistrict);
		return existingDistrict;
	}

	@Override
	public void deleteDistrict(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<District> getAllDistricts() {
		return districtRepository.findAll();
	}

	@Override
	public District getDistrictById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
