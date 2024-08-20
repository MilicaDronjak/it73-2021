package RVA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import RVA.models.Banka;


public interface BankaRepository extends JpaRepository<Banka, Integer> {

	List<Banka> findByNazivContainingIgnoreCase(String naziv);
	List<Banka> findByPibEquals (int pib);
}
