package com.springbootbackendapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootbackendapp.model.Talukas;
import com.springbootbackendapp.services.TalukaService;

@RestController
@RequestMapping("/api/v1")
public class TalukasController {

	@Autowired
	private TalukaService talukaService;

	@PostMapping("/taluka")
	public Talukas addTaluka(@RequestBody Talukas talukas) {
		return talukaService.addTaluka(talukas);
	}

}
