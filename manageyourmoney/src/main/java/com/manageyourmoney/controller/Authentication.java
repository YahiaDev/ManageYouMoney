package com.manageyourmoney.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.manageyourmoney.common.Config;
import com.manageyourmoney.dto.LoginDTO;
import com.manageyourmoney.mongodb.document.Adresse;
import com.manageyourmoney.mongodb.document.Person;
import com.manageyourmoney.mongodb.document.UserDocument;
import com.manageyourmoney.mongodb.repository.AdressRepo;
import com.manageyourmoney.service.AdressService;
import com.manageyourmoney.service.AuthenticationService;
import com.manageyourmoney.service.PersonService;

//@CrossOrigin(origins = Config.CROSS_URL)
@RestController
@RequestMapping(value = "/api")
public class Authentication {

	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private PersonService personService;

	@Autowired
	private AdressService adressService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.PUT)
	public UserDocument authenticate(@RequestBody LoginDTO loginDTO, HttpServletResponse response) throws Exception {
		// LoginDTO loginDTO = new LoginDTO();
		// loginDTO.setLogin("test@test.com");
		// loginDTO.setPassword("yahia");
		try {
			UserDocument userDto = authenticationService.authenticate(loginDTO, response);

			// Person person = new Person();
			// person.setPersonneId(1l);
			// person.setName("yahia");
			//
			// Adresse adress = new Adresse(1l, "15 rue raymond jaclard",
			// "alfortville", "france", 94140l);
			//
			// // List<Adresse> listAdress = new ArrayList<Adresse>;
			// // listAdress.add(adress);
			// person.getAddresses().add(adress);
			//
			// adressService.saveAdress(adress);
			// personService.savePerson(person);

			Iterable<Person> personIterable = personService.findAll();
			for (Person person2 : personIterable) {
				System.out.println(person2);
			}
			return userDto;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() throws Exception {
		System.out.println("yahia ammmaraaaaaa");
		return new String("ammar");
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout() {
		authenticationService.logout();
	}
}
