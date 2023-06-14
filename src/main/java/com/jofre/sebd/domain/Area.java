package com.jofre.sebd.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable =  false, length = 60, unique = true)
	private String nome;
	
	@OneToMany(mappedBy = "area")
	private List<Congregacao> congregacoes = new ArrayList<>();

	public Area() {
	}

	
	public Area(Integer id, String nome) {
	super();
	this.id = id;
	this.nome = nome;
}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Congregacao> getCongregacoes() {
		return congregacoes;
	}


	public void setCongregacoes(List<Congregacao> congregacoes) {
		this.congregacoes = congregacoes;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Area other = (Area) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "Area [id=" + id + ", nome=" + nome + "]";
	}
	
	
}
