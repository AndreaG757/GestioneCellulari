package it.prova.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "marca")
public class Marca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "data_fondazione")
	private Date dataFondazione;
	
	@Column(name = "numero_modelli")
	private Integer numeroModelli;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "marca")
	private Set<Modello> modelli = new HashSet<>();
	
	public Marca() {}

	public Marca(String nome, Date dataFondazione, Integer numeroModelli) {
		this.nome = nome;
		this.dataFondazione = dataFondazione;
		this.numeroModelli = numeroModelli;
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

	public Date getDataFondazione() {
		return dataFondazione;
	}

	public void setDataFondazione(Date dataFondazione) {
		this.dataFondazione = dataFondazione;
	}

	public Integer getNumeroModelli() {
		return numeroModelli;
	}

	public void setNumeroModelli(Integer numeroModelli) {
		this.numeroModelli = numeroModelli;
	}

	public Set<Modello> getModelli() {
		return modelli;
	}

	public void setModelli(Set<Modello> modelli) {
		this.modelli = modelli;
	}
	
	
	
}
