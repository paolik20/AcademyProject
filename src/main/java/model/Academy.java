package model;

import java.sql.Date;
import java.util.List;

public class Academy {

	private int id;
	private String nome;
	private Date dataInizio;
	private Date dataFine;
	private List<Discente> discenti;
	private List<Modulo> moduli;

	public Academy() {
		super();
	}

	public Academy(int id, String nome, Date dataInizio, Date dataFine) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
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

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public List<Discente> getDiscenti() {
		return discenti;
	}

	public void setDiscenti(List<Discente> discenti) {
		this.discenti = discenti;
	}

	public List<Modulo> getModuli() {
		return moduli;
	}

	public void setModuli(List<Modulo> moduli) {
		this.moduli = moduli;
	}

}