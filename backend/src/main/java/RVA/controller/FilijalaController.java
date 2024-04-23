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

import RVA.models.Banka;
import RVA.models.Filijala;
import RVA.services.BankaService;
import RVA.services.FilijalaService;

@CrossOrigin
@RestController
public class FilijalaController {

	private BankaService
	bankaService;
	
	@Autowired
	private FilijalaService service;
	
	@Autowired
	private FilijalaService filijalaService;
	
	@GetMapping("/filijala")
	public List<Filijala> getAllFilijalas(){
		return service.getAll();
	}
	
	@GetMapping("/filijala/id/{id}")
	public ResponseEntity<?> getFilijalaById(@PathVariable int id){
		Optional<Filijala> filijala = service.findById(id);
		if(filijala.isPresent()) {
			return ResponseEntity.ok(filijala.get());
		}
		return ResponseEntity.status(404).body("Resource with requested ID: " + id + " does not exist!");
	}
	
	@GetMapping("/filijala/poseduje_sef/{poseduje_sef}")
	public ResponseEntity<?> getPredmetsByFilijala(@PathVariable boolean poseduje_sef){
		List<Filijala> filijala = service.getFilijalasByPoseduje_sef(poseduje_sef);
		if(filijala.isEmpty()) {
			return ResponseEntity.status(404).body("Resources with poseduje_sef: " + poseduje_sef + " do not exist!");
		}
		return ResponseEntity.ok(filijala);
	}
	
	@PostMapping("/filijala")
	public ResponseEntity<?> createFilijala(@RequestBody Filijala filijala){
		if(service.existsById(filijala.getId())) {
			return ResponseEntity.status(409).body("Resource already exists!");
		}
		Filijala savedFilijala = service.create(filijala);
		URI uri = URI.create("/filijala/id/" + savedFilijala.getId());
		return ResponseEntity.created(uri).body(savedFilijala);
	}
	
	@PutMapping("/filijala/id/{id}")
	public ResponseEntity<?> updateFilijala(@RequestBody Filijala filijala, @PathVariable int id){
		Optional<Filijala> updatedFilijala = service.update(filijala, id);
		if(updatedFilijala.isPresent()) {
			return ResponseEntity.ok(updatedFilijala.get());
		}
		return ResponseEntity.status(404).body("Resource with requested ID: " + id + " could not be" + 
				" updated because it does not exist!");
	}
	
	@DeleteMapping("/filijala/id/{id}")
	public ResponseEntity<?> deleteFilijala(@PathVariable int id ){
		if(service.existsById(id)) {
			service.delete(id);
			return ResponseEntity.ok("Resource with ID: " + id + " has been deleted!");
		}
		return ResponseEntity.status(404).body("Resource with requested ID: " + id + " could not be" + 
				" deleted because it does not exist!");
	}
	
	@GetMapping("/filijala/banka/{foreignKey}")
	public ResponseEntity<?> getFilijalaByBanka(@PathVariable int foreignKey){
		Optional<Banka> banka = bankaService.findById(foreignKey);
		if(banka.isPresent()) {
			List<Filijala> filijala = service.getByForeignKey(banka.get());
			if(filijala.isEmpty()) {
				return ResponseEntity.status(404).body("Resources with foreign key: " + foreignKey
						+ " do not exist!");
			}else {
				return ResponseEntity.ok(filijala);
			}
		}
		return ResponseEntity.status(400).body("Invalid foreign key!");
	}
}