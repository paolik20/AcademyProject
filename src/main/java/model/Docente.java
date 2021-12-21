package model;

import java.util.List;

public class Docente {

	private int id;
	private String codiceFiscale;
	private String nome;
	private String cognome;
	private List<Modulo> moduli;

	public Docente() {
		super();
	}

	public Docente(int id, String codiceFiscale, String nome, String cognome) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public List<Modulo> getModuli() {
		return moduli;
	}

	public void setModuli(List<Modulo> moduli) {
		this.moduli = moduli;
	}

}