package RVA.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import RVA.models.Korisnik;
import RVA.repository.KorisnikRepository;
import RVA.services.KorisnikService;


@Component
public class KorisnikServiceImpl implements KorisnikService {
	
	@Autowired
	private KorisnikRepository repo;

	@Override
	public List<Korisnik> getAll() {
		return repo.findAll();
	}

	@Override
	public boolean existsById(int id) {
		return repo.existsById(id);
	}

	@Override
	public Korisnik create(Korisnik t) {
		return repo.save(t);
	}

	@Override
	public Optional<Korisnik> update(Korisnik t, int id) {
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
	public List<Korisnik> getKorisniksByIme(String ime) {
		return repo.findByImeContainingIgnoreCase(ime);
	}
	
	@Override
	public List<Korisnik> getKorisniksByPrezime(String prezime) {
		return repo.findByPrezimeContainingIgnoreCase(prezime);
	}
	
	@Override
	public List<Korisnik> getKorisniksByMaticni_broj(String maticni_broj) {
		return repo.findByMaticni_brojContainingIgnoreCase(maticni_broj);
	}

	@Override
	public Optional<Korisnik> findById(int id) {
		return repo.findById(id);
	}

}