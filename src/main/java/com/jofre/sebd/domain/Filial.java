package com.jofre.sebd.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Filial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message ="Informe um nome.")
	@Size(min = 3, max = 60, message = "A descrição da filial deve conter entre {min} e {max} caracteres.")
	@Column(nullable =  false, length = 60, unique = true)
	private String nome;
	
	@OneToMany(mappedBy = "filial")
	private List<Pessoa> pessoas = new ArrayList<>();

	public Filial() {
	}

	
	public Filial(Integer id) {
	super();
	this.id = id;
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

	public List<Pessoa> getPessoas() {
		return pessoas;
	}


	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
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
		Filial other = (Filial) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "Filial [id=" + id + ", nome=" + nome + ", pessoas=" + pessoas + "]";
	}


	
	
}
