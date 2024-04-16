package RVA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import RVA.models.Korisnik;


public interface KorisnikRepository extends JpaRepository<Korisnik, Integer>{

	List<Korisnik> findByImeContainingIgnoreCase(String ime);
	List<Korisnik> findByPrezimeContainingIgnoreCase(String prezime);
	List<Korisnik> findByMaticni_brojContainingIgnoreCase(String maticni_broj);

}
