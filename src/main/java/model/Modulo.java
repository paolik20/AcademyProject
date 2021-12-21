package model;

import java.sql.Date;
import java.util.List;

public class Modulo {

	private int id;
	private int posizione;
	private String nome;
	private String argomenti;
	private Date dataInizio;
	private Date dataFine;
	private Academy academy;
	private List<Docente> docenti;

	public Modulo() {
		super();
	}

	public Modulo(int id, int posizione, String nome, String argomenti, Date dataInizio, Date dataFine,
			Academy academy) {
		super();
		this.id = id;
		this.posizione = posizione;
		this.nome = nome;
		this.argomenti = argomenti;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.academy = academy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPosizione() {
		return posizione;
	}

	public void setPosizione(int posizione) {
		this.posizione = posizione;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArgomenti() {
		return argomenti;
	}

	public void setArgomenti(String argomenti) {
		this.argomenti = argomenti;
	}

	public Academy getAcademy() {
		return academy;
	}

	public void setAcademy(Academy academy) {
		this.academy = academy;
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

	public List<Docente> getDocenti() {
		return docenti;
	}

	public void setDocenti(List<Docente> docenti) {
		this.docenti = docenti;
	}

}
