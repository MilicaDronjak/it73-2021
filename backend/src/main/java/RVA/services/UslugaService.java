package RVA.services;

import java.util.List;

import org.springframework.stereotype.Service;

import RVA.models.Filijala;
import RVA.models.Korisnik;
import RVA.models.Usluga;



@Service
public interface UslugaService extends CrudService<Usluga> {

	List<Usluga> getUslugaByNaziv(String naziv);
	List<Usluga> getUslugaByForeignKey(Filijala filijala);
	List<Usluga> getUslugaByForeignKey(Korisnik korisnik);
}