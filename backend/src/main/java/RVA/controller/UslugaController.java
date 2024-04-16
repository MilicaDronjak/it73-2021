package RVA.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import RVA.models.Usluga;
import RVA.services.UslugaService;

@CrossOrigin
@RestController
public class UslugaController {

	@Autowired
	private UslugaService service;
	
	@GetMapping("/usluga")
	public List<Usluga> getAllUslugas(){
		return service.getAll();
	}
	
	@GetMapping("/usluga/id/{id}")
	public ResponseEntity<?> getUslugaById(@PathVariable int id){
		Optional<Usluga> usluga = service.findById(id);
		if(usluga.isPresent()) {
			return ResponseEntity.ok(usluga.get());
		}
		return ResponseEntity.status(404).body("Resource with requested ID: " + id + " does not exist!");
	}
	
	@GetMapping("/usluga/opis_usluge/{opis_usluge}")
	public ResponseEntity<?> getUcesniksByOpis_usluge(@PathVariable String opis_usluge){
		List<Usluga> usluga = service.getUslugasByNaziv(opis_usluge);
		if(usluga.isEmpty()) {
			return ResponseEntity.status(404).body("Resources with opis_usluge: " + opis_usluge + " do not exist!");
		}
		return ResponseEntity.ok(usluga);
	}
	
	@GetMapping("/usluga/naziv/{naziv}")
	public ResponseEntity<?> getUslugasByNaziv(@PathVariable String naziv){
		List<Usluga> usluga = service.getUslugasByNaziv(naziv);
		if(usluga.isEmpty()) {
			return ResponseEntity.status(404).body("Resources with naziv: " + naziv + " do not exist!");
		}
		return ResponseEntity.ok(usluga);
	}
	
	@PostMapping("/usluga")
	public ResponseEntity<?> createUsluga(@RequestBody Usluga usluga){
		if(service.existsById(usluga.getId())) {
			return ResponseEntity.status(409).body("Resource already exists!");
		}
		Usluga savedUsluga = service.create(usluga);
		URI uri = URI.create("/usluga/id/" + savedUsluga.getId());
		return ResponseEntity.created(uri).body(savedUsluga);
	}
	
	@PutMapping("/usluga/id/{id}")
	public ResponseEntity<?> updateUsluga(@RequestBody Usluga usluga, @PathVariable int id){
		Optional<Usluga> updatedUsluga = service.update(usluga, id);
		if(updatedUsluga.isPresent()) {
			return ResponseEntity.ok(updatedUsluga.get());
		}
		return ResponseEntity.status(404).body("Resource with requested ID: " + id + " could not be" + 
				" updated because it does not exist!");
	}
	
	@DeleteMapping("/usluga/id/{id}")
	public ResponseEntity<?> deleteUsluga(@PathVariable int id ){
		if(service.existsById(id)) {
			service.delete(id);
			return ResponseEntity.ok("Resource with ID: " + id + " has been deleted!");
		}
		return ResponseEntity.status(404).body("Resource with requested ID: " + id + " could not be" + 
				" deleted because it does not exist!");
	}
}