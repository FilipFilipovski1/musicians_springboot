package musicians.springboot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import musicians.springboot.model.Musician;
import musicians.springboot.service.MusicianService;

@RestController
public class MusicianController {
	
	@Autowired
	private MusicianService musicianService;

	@GetMapping("/musicians")
	public ResponseEntity<List<Musician>> getAllMusicians() {
		return new ResponseEntity<List<Musician>>(musicianService.getAllMusicians(),HttpStatus.OK);
	}
	
	@PostMapping("/musicians")
	public ResponseEntity<Musician> createMusician(@RequestBody Musician musician) {
		return new ResponseEntity<Musician>(musicianService.createMusician(musician),HttpStatus.CREATED);
	}
	
	@GetMapping("/musicians/{id}")
	public ResponseEntity<Musician> getSingeMusician(@PathVariable Integer id) {
		return new ResponseEntity<Musician>(musicianService.getSingleMusician(id),HttpStatus.OK);
	}
	
	@PutMapping("/musicians/{id}")
	public ResponseEntity<Musician> editMusician(@RequestBody Musician musician,@PathVariable Integer id) {
		musician.setId(id);
		return new ResponseEntity<Musician>(musicianService.createMusician(musician),HttpStatus.OK);
	}
	
	@DeleteMapping("/musicians/{id}")
	public ResponseEntity<HttpStatus> deleteMusician(@PathVariable Integer id) {
		musicianService.deleteMusician(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
}
