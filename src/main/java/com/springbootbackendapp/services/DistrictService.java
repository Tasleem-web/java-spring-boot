package com.springbootbackendapp.services;

import java.util.Collection;
import java.util.List;

import com.springbootbackendapp.model.District;

public interface DistrictService {

	District addDistrict(District district);
	
	Collection<District> addMultipleDistrict(Collection<District> district);

	District updateDistrict(District district, Long id);

	void deleteDistrict(Integer id);

	List<District> getAllDistricts();

	District getDistrictById(Integer id);

}
