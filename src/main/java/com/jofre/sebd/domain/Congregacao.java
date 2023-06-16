package com.jofre.sebd.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Congregacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message ="Informe o nome da congregação.")
	@Size(min = 3, max = 60, message = "A descrição da congregação deve conter entre {min} e {max} caracteres.")
	@Column(nullable =  false, length = 60)
	private String nome;
	
	@NotNull(message = "Selecione uma área.")
	@ManyToOne
	@JoinColumn(name= "id_area")
	private Area area;

	
	public Congregacao() {
	}

	public Congregacao(Integer id) {
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

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
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
		Congregacao other = (Congregacao) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Congregacao [id=" + id + ", nome=" + nome + ", area=" + area + "]";
	}

	
}
