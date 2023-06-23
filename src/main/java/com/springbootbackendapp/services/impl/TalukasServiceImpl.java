package com.springbootbackendapp.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.springbootbackendapp.model.Talukas;
import com.springbootbackendapp.repository.TalukaRepository;
import com.springbootbackendapp.services.TalukaService;

@Service
public class TalukasServiceImpl implements TalukaService {

	@Autowired
	private TalukaRepository talukaRepository;

	@Override
	public Talukas addTaluka(Talukas talukas) {
		return talukaRepository.save(talukas);
	}

	@Override
	public Talukas updateTaluka(Talukas talukas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTaluka(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Talukas> getAllTalukas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Talukas getTalukaById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
