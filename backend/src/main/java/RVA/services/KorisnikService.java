package RVA.services;

import java.util.List;

import org.springframework.stereotype.Service;

import RVA.models.Korisnik;

@Service
public interface KorisnikService extends CrudService<Korisnik>{
	List<Korisnik> getKorisniksByIme(String ime);
	List<Korisnik> getKorisniksByPrezime(String prezime);
	List<Korisnik> getKorisniksByMaticni_broj(String maticni_broj);
}
