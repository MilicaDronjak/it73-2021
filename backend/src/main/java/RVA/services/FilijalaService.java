package RVA.services;

import java.util.List;

import org.springframework.stereotype.Service;

import RVA.models.Banka;
import RVA.models.Filijala;



@Service
public interface FilijalaService extends CrudService<Filijala> {
	
	List<Filijala> getFilijalaByForeignKey (Banka banka);
	List<Filijala> getFilijalaByAdresa(String adresa);
	List<Filijala> getFilijalaByPosedujeSef (boolean posedujeSef);


}