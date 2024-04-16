package RVA.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Banka implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "BANKA_SEQ_GENERATOR", sequenceName = "BANKA_SEQ",
	allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BANKA_SEQ_GENERATOR")
	private int id;
	private String naziv;
	private String kontakt;
	private int PIB;
	
	public Banka() {
		
	}
	
	public Banka(int id, String naziv, String kontakt, int PIB) {
		this.id = id;
		this.naziv = naziv;
		this.kontakt=kontakt;
		this.PIB=PIB;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	

	public String getKontakt() {
		return kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}
	

	public int getPIB() {
		return PIB;
	}

	public void setPIB(int PIB) {
		this.PIB = PIB;
	}
}
