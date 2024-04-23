package RVA.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import RVA.models.Banka;
import RVA.services.BankaService;

@CrossOrigin
@RestController
public class BankaController {

	@Autowired
	private BankaService service;
	
	@GetMapping("/sud")
	public List<Banka> getAllSuds(){
		return service.getAll();
	}
	
	@GetMapping("/banka/id/{id}")
	public ResponseEntity<?> getBankaById(@PathVariable int id){
		Optional<Banka> banka = service.findById(id);
		if(banka.isPresent()) {
			return ResponseEntity.ok(banka.get());
		}
		return ResponseEntity.status(404).body("Resource with requested ID:" + 
		id + " does not exist.");
	}
	
	@GetMapping("/banka/naziv/{naziv}")
	public ResponseEntity<?> getBankasByNaziv(@PathVariable String naziv){
		List<Banka> bankas = service.getBankasByNaziv(naziv);
		if(bankas.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resources"
					+ " with Naziv: " + naziv + " could not be found.");
		}
		return ResponseEntity.ok(bankas);
	}
	
	@PostMapping("/banka")
	public ResponseEntity<?> createBanka(@RequestBody Banka banka){
		if(service.existsById(banka.getId())) {
			return ResponseEntity.status(409).body("Resource with" +
		" inserted values already exists.");
		} 
		Banka savedBanka = service.create(banka);
		URI uri = URI.create("/banka/" + savedBanka.getId());
		return ResponseEntity.created(uri).body(savedBanka);
	}
	
	@PutMapping("/Banka/id/{id}")
	public ResponseEntity<?> updateBanka(@RequestBody Banka banka, @PathVariable int id){
		Optional<Banka> updatedBanka = service.update(banka, id);
		if(updatedBanka.isPresent())  {
			return ResponseEntity.ok(updatedBanka);
		} 
		return ResponseEntity.status(404).body("Resource with requested ID: " +
		+ id + " cannont be updated as it doesn't exist.");
	}
	
	@DeleteMapping("/banka/id/{id}")
	public ResponseEntity<?> deletedSud(@PathVariable int id) {
		if(service.existsById(id)) {
			service.delete(id);
			return ResponseEntity.ok("Resource with ID: " + id +
					"has been deleted.");
		}
		return ResponseEntity.status(404).body("Resourse with requested ID: " +
		" cannont be deleted as it doesn't exist.");
				
	}
	
}