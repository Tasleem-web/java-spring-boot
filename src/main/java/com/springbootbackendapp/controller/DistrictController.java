package com.springbootbackendapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootbackendapp.model.District;
import com.springbootbackendapp.services.DistrictService;

@RestController
@RequestMapping("/api/v1")
public class DistrictController {

	@Autowired
	public DistrictService districtService;

	@PostMapping("/addDistrict")
	public ResponseEntity<District> addDistrict(@RequestBody District district) {
		return new ResponseEntity<District>(districtService.addDistrict(district), HttpStatus.OK);
	}

	@GetMapping("/districts")
	public List<District> geAllDistricts() {
		return districtService.getAllDistricts();
	}

	@PutMapping("/district/{id}")
	public ResponseEntity<District> updateDistrict(@RequestBody District district, @PathVariable Long id) {
		return new ResponseEntity<District>(districtService.updateDistrict(district, id), HttpStatus.OK);
	}

	@PostMapping("/addBulkDistrict")
	public ResponseEntity<District> addMultipleDistrict(@RequestBody List<District> district) {
		return new ResponseEntity<District>((District) districtService.addMultipleDistrict(district), HttpStatus.OK);
	}
}
