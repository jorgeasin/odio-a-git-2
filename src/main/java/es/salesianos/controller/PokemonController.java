package es.salesianos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.salesianos.model.Person;



@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api/v1/user")
public class PokemonController {

	@Autowired
	private Person person;

	

	@PostMapping
	@RequestMapping(value = "/create")
	public ResponseEntity<Person> create(@RequestBody Person person) {
		//person.insertOrupdateUser(person);
		return new ResponseEntity<>(person, HttpStatus.CREATED);
	}

	@PostMapping
	@RequestMapping(value = "/list")
	public ResponseEntity<Person> ListWithFilter() {
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}

	@PostMapping
	@RequestMapping(value = "/delete")
	public ResponseEntity<Person> delete() {
		person.delete(person);
		return new ResponseEntity<Person>(person, HttpStatus.CREATED);
	}

}
