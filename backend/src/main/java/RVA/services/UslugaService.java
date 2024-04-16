package RVA.services;

import java.util.List;

import org.springframework.stereotype.Service;

import RVA.models.Filijala;
import RVA.models.Korisnik;
import RVA.models.Usluga;



@Service
public interface UslugaService extends CrudService<Usluga>{
	
	List<Usluga> getUslugasByNaziv(String naziv);
	List<Usluga> getByFilijala(Filijala filijala);
	List<Usluga> getByKorisnik(Korisnik korisnik);

}
