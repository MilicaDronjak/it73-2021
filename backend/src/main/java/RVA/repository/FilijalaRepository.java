package RVA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import RVA.models.Banka;
import RVA.models.Filijala;



public interface FilijalaRepository extends JpaRepository<Filijala, Integer> {
	
	List<Filijala> findByBanka (Banka banka);
	List<Filijala> findByAdresaContainingIgnoreCase (String adresa);
	List<Filijala> findByPosedujeSef (boolean posedujeSef);
}