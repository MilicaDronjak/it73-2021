package RVA.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;

import RVA.models.Banka;
import RVA.models.Filijala;
import RVA.repository.FilijalaRepository;
import RVA.services.FilijalaService;


public class FilijalaServiceImpl implements FilijalaService {
	@Autowired
	private FilijalaRepository repo;
	
	@Override
	public List<Filijala> getAll() {
		return repo.findAll();
	}

	@Override
	public boolean existsById(int id) {
		return repo.existsById(id);
	}

	@Override
	public Optional<Filijala> findById(int id) {
		return repo.findById(id);
	}

	@Override
	public Filijala create(Filijala t) {
		return repo.save(t);
	}

	@Override
	public Optional<Filijala> update(Filijala t, int id) {
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
	public List<Filijala> getFilijalasByPoseduje_sef(boolean poseduje_sef) {
		return repo.findByPoseduje_sefEquals(poseduje_sef);
	}
	
	@Override
	public List<Filijala> getFilijalasByAdresa(String adresa) {
		return repo.findByAdresaEquals(adresa);
	}
	
	@Override
	public List<Filijala> getFilijalasByBroj_pultova(int broj_pultova) {
		return repo.findByBroj_pultovaEquals(broj_pultova);
	}
	
	@Override
	public List<Filijala> getByForeignKey(Banka banka) {
		return repo.findByBanka(banka);
	}
}
