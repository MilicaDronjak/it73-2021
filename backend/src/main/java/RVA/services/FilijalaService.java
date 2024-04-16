package RVA.services;

import java.util.List;

import org.springframework.stereotype.Service;

import RVA.models.Banka;
import RVA.models.Filijala;



@Service
public interface FilijalaService extends CrudService<Filijala>{
	
	List<Filijala> getFilijalasByAdresa(String adresa);
	List<Filijala> getFilijalasByBroj_pultova(int broj_pultova);
	List<Filijala> getFilijalasByPoseduje_sef(boolean poseduje_sef);
	List<Filijala> getByForeignKey(Banka banka);

}
