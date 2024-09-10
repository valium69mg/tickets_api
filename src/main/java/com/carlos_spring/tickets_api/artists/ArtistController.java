package com.carlos_spring.tickets_api.artists;

import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtistController {

	private ArtistRepository artistRepository;
	
	
	@PostMapping("/artist")
	public ResponseEntity<Object> createArtist(@RequestBody Map<String,String> json) {
		// get params
		String name = json.get("name"); // artist name
		String image = json.get("image"); //img source
		// error handling the req body
		if (name == null) {
			return new ResponseEntity<>("Name of artist is null. ", HttpStatus.BAD_REQUEST);
		} else if (image == null) {
			return new ResponseEntity<>("Image source of artist is null. ", HttpStatus.BAD_REQUEST);
		}
		Artist newArtist = new Artist(name,image);
		return new ResponseEntity<>(artistRepository.save(newArtist),HttpStatus.CREATED);
	}
	
	@GetMapping("/artist/{id}")
	public ResponseEntity<Object> getArtistById(@PathVariable Integer id) {
		// if artist exists
		if (artistRepository.findById(id).isPresent()) {
			Artist foundArtist = artistRepository.findById(id).get();
			return new ResponseEntity<Object>(foundArtist,HttpStatus.OK);
		}
		throw new NoSuchElementException();
	}
	
	@PatchMapping("/artist/{id}")
	public ResponseEntity<Object> updateNameOrImage(@RequestBody Map<String,String> json, @PathVariable Integer id) {
		String name = json.get("name");
		String image = json.get("image");
		if (artistRepository.findById(id).isEmpty()) {
			throw new NoSuchElementException();
		}
		if (name == null & image == null) {
			return new ResponseEntity<Object>("Parameters not matched, must be name, image or both",HttpStatus.BAD_REQUEST);
		}
		if (name != null) {
			artistRepository.findById(id).get().setName(name);
		}	
		if (image != null) {
			artistRepository.findById(id).get().setImage(image);
		}
		// save and return patched artist 
		artistRepository.save(artistRepository.findById(id).get());
		return new ResponseEntity<Object>(artistRepository.findById(id).get(),HttpStatus.OK);
	}
	
	@DeleteMapping("/artist/{id}")
	public ResponseEntity<Object> deleteArtist(@PathVariable Integer id) {
		// if artist does not exist
		if (artistRepository.findById(id).isEmpty()) {
			throw new NoSuchElementException();
		}
		// delete artist
		artistRepository.delete(artistRepository.findById(id).get());
		return new ResponseEntity<Object>("Artist deleted. ",HttpStatus.ACCEPTED);
	}
	
}
