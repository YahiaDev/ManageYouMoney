package com.manageyourmoney.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manageyourmoney.mongodb.document.Adresse;
import com.manageyourmoney.mongodb.repository.AdressRepo;

@Service
public class AdressService {
	@Autowired
	AdressRepo adressRepo;

	public void saveAdress(Adresse adresse) {
		adressRepo.save(adresse);
	}
}
