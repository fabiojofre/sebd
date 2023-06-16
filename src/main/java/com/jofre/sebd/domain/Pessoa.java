package com.jofre.sebd.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

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
public class Pessoa  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message ="Informe seu nome.")
	@Size(min = 10, max = 60, message = "Seu nome deve conter entre {min} e {max} caracteres.")
	@Column(nullable = false)
	private String nome;
	
	@NotNull(message = "Insira o número do seu Cartão de Membro.")
	@NumberFormat(style=Style.CURRENCY)
	@Column(nullable = false)
	private Long cartaoMembro;
	
	@NotBlank(message ="Selecione uma função.")
	@Column(nullable = true)
	private String funcao;
	
	@NotBlank(message ="Informe um telefone válido.")
	@Column(nullable = false)
	private String telefone;
	
	@NotBlank(message ="Informe uma congregação.")
	@Size(min = 3, max = 60, message = "Nome da congregação deve conter entre {min} e {max} caracteres.")
	@Column(nullable = false)
	private String nomeCongregacao;
	
	@NotNull(message = "Selecione uma área válida.")
	@Column(nullable = false)
	private Integer areaNumero;
	
	@NotNull(message = "Selecione seu setor ou filial.")
	@ManyToOne
	@JoinColumn(name = "filial_id")
	private Filial filial;
	
	@Column(nullable = true)
	private Boolean conferido;
	
	
	public Pessoa() {
	}

	public Pessoa(Integer id, String nome, Long cartaoMembro, 
			String nomeCongregacao, Integer areaNumero,
			Filial filial, Boolean conferido) {
		super();
		this.id = id;
		this.nome = nome;
		this.cartaoMembro = cartaoMembro;
		this.nomeCongregacao = nomeCongregacao;
		this.areaNumero = areaNumero;
		this.filial = filial;
		this.conferido = conferido;
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
	
	

	public Boolean getConferido() {
		return conferido;
	}

	public void setConferido(Boolean conferido) {
		this.conferido = conferido;
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


}
