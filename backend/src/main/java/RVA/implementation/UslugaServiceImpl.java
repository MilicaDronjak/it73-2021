package RVA.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import RVA.models.Filijala;
import RVA.models.Korisnik;
import RVA.models.Usluga;
import RVA.repository.UslugaRepository;
import RVA.services.UslugaService;


@Component
public class UslugaServiceImpl implements UslugaService{

	@Autowired
	private UslugaRepository repo;
	
	@Override
	public List<Usluga> getAll() {
		return repo.findAll();
	}

	@Override
	public boolean existsById(int id) {
		return repo.existsById(id);
	}

	@Override
	public Optional<Usluga> findById(int id) {
		return repo.findById(id);
	}

	@Override
	public Usluga create(Usluga t) {
		return repo.save(t);
	}

	@Override
	public Optional<Usluga> update(Usluga t, int id) {
		if(existsById(id)) {
			t.setId(id);
			return Optional.of(repo.save(t));
		}
		return Optional.empty();
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
	}

	@Override
	public List<Usluga> getUslugasByNaziv(String naziv) {
		return repo.findByNazivContainingIgnoreCase(naziv);
	}

	@Override
	public List<Usluga> getByFilijala(Filijala filijala) {
		return repo.findByFilijala(filijala);
	}

	@Override
	public List<Usluga> getByKorisnik(Korisnik korisnik) {
		return repo.findByKorisnik(korisnik);
	}

	
}