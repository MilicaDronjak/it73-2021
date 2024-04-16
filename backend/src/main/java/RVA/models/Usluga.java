package RVA.models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

public class Usluga implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "Usluga_SEQ_GENERATOR", sequenceName = "Usluga_SEQ",
	allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Usluga_SEQ_GENERATOR")
	private int id;
	private String naziv;
	private String opis_usluge;
	private Date datum_ugovora;
	private int provizija;
	
	@ManyToOne // strani kljuc
	@JoinColumn(name = "usluga")
	private Filijala filijala;
	
	@ManyToOne // strani kljuc
	@JoinColumn(name = "usluga")
	private Korisnik korisnik;
	
	public Usluga() {
		
	}

	public Usluga(int id, String naziv, String opis_usluge, Date datum_ugovora,int provizija, Filijala filijala,Korisnik korisnik) {
		this.id = id;
		this.naziv = naziv;
		this.opis_usluge=opis_usluge;
		this.datum_ugovora=datum_ugovora;
		this.provizija=provizija;
		this.filijala=filijala;
		this.korisnik=korisnik;
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
	
	public String getOpis_usluge() {
		return opis_usluge;
	}

	public void setOpis_usluge(String opis_usluge) {
		this.opis_usluge = opis_usluge;
	}
	

	public Date getDatum_ugovora() {
		return datum_ugovora;
	}

	public void setDatum_ugovora(Date datum_ugovora) {
		this.datum_ugovora = datum_ugovora;
	}
	

	public int getProvizija() {
		return provizija;
	}

	public void setProvizija(int Provizija) {
		this.provizija = provizija;
	}
	
	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	
	public Filijala getFilijala() {
		return filijala;
	}

	public void setFilijala(Filijala filijala) {
		this.filijala = filijala;
	}

	
}
