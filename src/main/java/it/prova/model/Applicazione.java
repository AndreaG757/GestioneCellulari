package it.prova.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "applicazione")
public class Applicazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "peso")
	private Double peso;
	
	@Column(name = "download")
	private Double download;
	
	@Column(name = "tipologia")
	private String tipologia;
	
	@ManyToMany(mappedBy = "applicazioni")
	private Set<Modello> modelli = new HashSet<>();

	public Applicazione() {

	}

	public Applicazione(String nome, Double peso, Double download, String tipologia) {
		this.nome = nome;
		this.peso = peso;
		this.download = download;
		this.tipologia = tipologia;
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

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getDownload() {
		return download;
	}

	public void setDownload(Double download) {
		this.download = download;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public Set<Modello> getModelli() {
		return modelli;
	}

	public void setModelli(Set<Modello> modelli) {
		this.modelli = modelli;
	}
	
	public void addToModello(Modello modello) {
		this.modelli.add(modello);
		modello.getApplicazioni().add(this);
	}
	
	public void removeFromModello(Modello modello) {
		this.modelli.remove(modello);
		modello.getApplicazioni().remove(this);
	}
	
}
