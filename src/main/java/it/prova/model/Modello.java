package it.prova.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "modello")
public class Modello {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "data_uscita")
	private Date dataUscita;
	
	@Column(name = "prezzo")
	private Double prezzo;
	
	@Column(name = "memoria")
	private Integer memoria;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.PERSIST})
	@JoinColumn(name = "marca_id")
	private Marca marca;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "modello_applicazione", 
			   joinColumns = @JoinColumn(name = "modello_id", referencedColumnName = "ID"), 
			   inverseJoinColumns = @JoinColumn(name = "applicazione_id", referencedColumnName = "ID"))
	private Set<Applicazione> applicazioni = new HashSet<>();
	
	public Modello() {
	}

	public Modello(String nome, Date dataUscita, Double prezzo, Integer memoria) {
		this.nome = nome;
		this.dataUscita = dataUscita;
		this.prezzo = prezzo;
		this.memoria = memoria;
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

	public Date getDataUscita() {
		return dataUscita;
	}

	public void setDataUscita(Date dataUscita) {
		this.dataUscita = dataUscita;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public Integer getMemoria() {
		return memoria;
	}

	public void setMemoria(Integer memoria) {
		this.memoria = memoria;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Set<Applicazione> getApplicazioni() {
		return applicazioni;
	}

	public void setApplicazioni(Set<Applicazione> applicazioni) {
		this.applicazioni = applicazioni;
	}
	
	public void addToApp(Applicazione applicazione) {
		this.applicazioni.add(applicazione);
		applicazione.getModelli().add(this);
	}
	
	public void removeFromApp(Applicazione applicazione) {
		this.applicazioni.remove(applicazione);
		applicazione.getModelli().remove(this);
	}
	
}
