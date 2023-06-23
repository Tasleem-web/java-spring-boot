package com.springbootbackendapp.services;

import java.util.List;

import com.springbootbackendapp.model.Talukas;

public interface TalukaService {

	Talukas addTaluka(Talukas talukas);

	Talukas updateTaluka(Talukas talukas);

	void deleteTaluka(Integer id);

	List<Talukas> getAllTalukas();

	Talukas getTalukaById(Integer id);
}
