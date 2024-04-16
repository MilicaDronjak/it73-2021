package RVA.models;

import java.io.Serializable;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

public class Filijala implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "FILIJALA_SEQ_GENERATOR", sequenceName = "FILIJALA_SEQ",
	allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FILIJALA_SEQ_GENERATOR")
	private int id;
	private String adresa;
	private int broj_pultova;
	private boolean poseduje_sef;
	
	@ManyToOne // strani kljuc
	@JoinColumn(name = "filijala")
	private Banka banka;
	
	public Filijala() {
		
	}
	
	public Filijala(int id, String adresa, int broj_pultova, boolean poseduje_sef, Banka banka) {
		this.id = id;
		this.adresa = adresa;
		this.broj_pultova = broj_pultova;
		this.poseduje_sef = poseduje_sef;
		this.banka = banka;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public int getBroj_pultova() {
		return broj_pultova;
	}

	public void setBroj_pultova(int broj_pultova) {
		this.broj_pultova = broj_pultova;
	}
	
	public boolean getPoseduje_sef() {
		return poseduje_sef;
	}

	public void setPoseduje_sef(boolean poseduje_sef) {
		this.poseduje_sef = poseduje_sef;
	}
	
	public Banka getBanka() {
		return banka;
	}

	public void setBanka(Banka banka) {
		this.banka = banka;
	}


}
