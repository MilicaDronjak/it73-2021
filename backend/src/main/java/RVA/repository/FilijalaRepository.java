package RVA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import RVA.models.Banka;
import RVA.models.Filijala;



public interface FilijalaRepository extends JpaRepository<Filijala, Integer>{
	
	List<Banka> findByBroj_pultovaContainingIgnoreCase(int broj_pultova);
	List<Filijala> findByPoseduje_sefEquals (boolean Poseduje_sef);
	List<Filijala> findByBanka (Banka banka);
	List<Filijala> findByAdresaEquals(String adresa);
	List<Filijala> findByBroj_pultovaEquals(int broj_pultova);
}
