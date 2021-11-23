package it.prova.dottore.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dottore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cognome;
	private String codiceDipendente;
	private boolean inVisita;
	private boolean inServizio;

	public Dottore() {
		// TODO Auto-generated constructor stub
	}
	public Dottore(Long id, String nome, String cognome, String codiceDipendente, boolean inVisita,
			boolean inServizio) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceDipendente = codiceDipendente;
		this.inVisita = inVisita;
		this.inServizio = inServizio;
	}
	

	public Dottore(String nome, String cognome, String codiceDipendente, boolean inVisita, boolean inServizio) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codiceDipendente = codiceDipendente;
		this.inVisita = inVisita;
		this.inServizio = inServizio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getCodiceDipendente() {
		return codiceDipendente;
	}

	public void setCodiceDipendente(String codiceDipendente) {
		this.codiceDipendente = codiceDipendente;
	}

	public boolean isInVisita() {
		return inVisita;
	}

	public void setInVisita(boolean inVisita) {
		this.inVisita = inVisita;
	}

	public boolean isInServizio() {
		return inServizio;
	}

	public void setInServizio(boolean inServizio) {
		this.inServizio = inServizio;
	}

}