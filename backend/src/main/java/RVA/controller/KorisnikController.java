package RVA.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import RVA.models.Korisnik;
import RVA.services.KorisnikService;


@RestController
public class KorisnikController {

	@Autowired
	private KorisnikService service;
	
	@GetMapping("/korisnik")
	public List<Korisnik> getAllUcesniks(){
		return service.getAll();
	}
	
	@GetMapping("/korisnik/id/{id}")
	public ResponseEntity<?> getKorisnikById(@PathVariable int id){
		Optional<Korisnik> korisnik = service.findById(id);
		if(korisnik.isPresent()) {
			return ResponseEntity.ok(korisnik.get());
		}
		return ResponseEntity.status(404).body("Resource with requested ID: " + id + " does not exist!");
	}
	
	@GetMapping("/korisnik/ime/{ime}")
	public ResponseEntity<?> getKorisniksByIme(@PathVariable String ime){
		List<Korisnik> korisnik = service.getKorisniksByIme(ime);
		if(korisnik.isEmpty()) {
			return ResponseEntity.status(404).body("Resources with Ime: " + ime + " do not exist!");
		}
		return ResponseEntity.ok(korisnik);
	}
	
	@GetMapping("/korisnik/maticni_broj/{maticni_broj}")
	public ResponseEntity<?> getKorisniksByMaticni_broj(@PathVariable String maticni_broj){
		List<Korisnik> Korisnik = service.getKorisniksByMaticni_broj(maticni_broj);
		if(Korisnik.isEmpty()) {
			return ResponseEntity.status(404).body("Resources with Mbr: " + maticni_broj + " do not exist!");
		}
		return ResponseEntity.ok(Korisnik);
	}
	
	@PostMapping("/korisnik")
	public ResponseEntity<?> createKorisnik(@RequestBody Korisnik korisnik){
		if(service.existsById(korisnik.getId())) {
			return ResponseEntity.status(409).body("Resource already exists!");
		}
		Korisnik savedKorisnik = service.create(korisnik);
		URI uri = URI.create("/korisnik/id/" + savedKorisnik.getId());
		return ResponseEntity.created(uri).body(savedKorisnik);
	}
	
	@PutMapping("/korisnik/id/{id}")
	public ResponseEntity<?> updateUcesnik(@RequestBody Korisnik korisnik, @PathVariable int id){
		Optional<Korisnik> updatedKorisnik = service.update(korisnik, id);
		if(updatedKorisnik.isPresent()) {
			return ResponseEntity.ok(updatedKorisnik.get());
		}
		return ResponseEntity.status(404).body("Resource with requested ID: " + id + " could not be" + 
				" updated because it does not exist!");
	}
	
	@DeleteMapping("/korisnik/id/{id}")
	public ResponseEntity<?> deleteKorisnik(@PathVariable int id ){
		if(service.existsById(id)) {
			service.delete(id);
			return ResponseEntity.ok("Resource with ID: " + id + " has been deleted!");
		}
		return ResponseEntity.status(404).body("Resource with requested ID: " + id + " could not be" + 
				" deleted because it does not exist!");
	}
}