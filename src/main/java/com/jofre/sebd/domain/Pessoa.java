package com.jofre.sebd.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Pessoa  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String nome;
	
	@NumberFormat(style=Style.CURRENCY)
	@Column(nullable = true)
	private Long cartaoMembro;
	
	@Column(nullable = true)
	private String funcao;
	
	
	@Column(nullable = true)
	private String telefone;
	
	@DateTimeFormat(iso=ISO.DATE)
	@Column(nullable = true, columnDefinition = "DATE")
	private LocalDate dataNasc;
	
	@Column(nullable = true)
	private String nomeCongregacao;
	
	@Column(nullable = true)
	private Integer areaNumero;
	
	@DateTimeFormat(iso=ISO.DATE)
	@Column(nullable = true, columnDefinition = "DATE")
	private LocalDate dataEntrada;
	
	@DateTimeFormat(iso=ISO.DATE)
	@Column(nullable = true,columnDefinition = "DATE")
	private LocalDate dataSaida;
	
	
	@ManyToOne
	@JoinColumn(name = "filial_id")
	private Filial filial;
	
	
	public Pessoa() {
	}

	public Pessoa(Integer id, String nome, Long cartaoMembro, LocalDate dataNasc,
			String nomeCongregacao, Integer areaNumero, LocalDate dataEntrada, LocalDate dataSaida,
			Filial filial) {
		super();
		this.id = id;
		this.nome = nome;
		this.cartaoMembro = cartaoMembro;
		this.dataNasc = dataNasc;
		this.nomeCongregacao = nomeCongregacao;
		this.areaNumero = areaNumero;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.filial = filial;
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


	public Long getCartaoMembro() {
		return cartaoMembro;
	}

	public void setCartaoMembro(Long cartaoMembro) {
		this.cartaoMembro = cartaoMembro;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getNomeCongregacao() {
		return nomeCongregacao;
	}

	public void setNomeCongregacao(String nomeCongregacao) {
		this.nomeCongregacao = nomeCongregacao;
	}

	public Integer getAreaNumero() {
		return areaNumero;
	}

	public void setAreaNumero(Integer areaNumero) {
		this.areaNumero = areaNumero;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	
	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id);
	}




	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", cartaoMembro=" + cartaoMembro
				+ ", dataNasc=" + dataNasc + ", nomeCongregacao=" + nomeCongregacao + ", areaNumero=" + areaNumero
				+ ", dataEntrada=" + dataEntrada + ", dataSaida=" + dataSaida 
				+ ", filial=" + filial + "]";
	}
	
	
}
