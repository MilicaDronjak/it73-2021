package RVA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import RVA.models.Filijala;
import RVA.models.Korisnik;
import RVA.models.Usluga;



public interface UslugaRepository extends JpaRepository<Usluga, Integer>{

	List<Usluga> findByNazivContainingIgnoreCase(String naziv);
	List<Usluga> findByOpis_uslugeContainingIgnoreCase(String opis_usluge);
	List<Usluga> findByFilijala(Filijala filijala);
	List<Usluga> findByKorisnik(Korisnik korisnik);
}