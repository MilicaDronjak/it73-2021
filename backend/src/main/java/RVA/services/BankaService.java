package RVA.services;

import java.util.List;

import org.springframework.stereotype.Service;

import RVA.models.Banka;

@Service
public interface BankaService extends CrudService<Banka> {

	List<Banka> getBankasByNaziv(String naziv);
	List<Banka> getBankasByKontakt(String kontakt);
	List<Banka> getBankasByPIB (int PIB);
}

