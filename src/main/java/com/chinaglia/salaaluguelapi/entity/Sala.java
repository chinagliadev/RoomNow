package com.chinaglia.salaaluguelapi.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_sala")
public class Sala implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numero;
	private String nome;
	
	@OneToMany(mappedBy = "sala", cascade = CascadeType.ALL)
	private Set<SalaRecurso> recursos = new HashSet<>();
	
	@OneToMany(mappedBy = "sala", cascade = CascadeType.ALL)
	private Set<AluguelSala> alugueis= new HashSet<>();
	
	private Integer capacidade;
	private BigDecimal valor_hora;
	private boolean status;
	
	public Sala() {}
	
	public Sala(Long id, String numero, String nome, Integer capacidade, BigDecimal valor_hora, boolean status) {
		this.id = id;
		this.numero = numero;
		this.nome = nome;
		this.capacidade = capacidade;
		this.valor_hora = valor_hora;
		this.status = status;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}
	public BigDecimal getValor_hora() {
		return valor_hora;
	}
	public void setValor_hora(BigDecimal valor_hora) {
		this.valor_hora = valor_hora;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setRecursos(Set<SalaRecurso> recursos) {
		this.recursos = recursos;
	}

	public void setAlugueis(Set<AluguelSala> alugueis) {
		this.alugueis = alugueis;
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
		Sala other = (Sala) obj;
		return Objects.equals(id, other.id);
	}
	
}
