package com.chinaglia.salaaluguelapi.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.chinaglia.salaaluguelapi.enums.UserRole;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_usuario")
public class Usuario implements Serializable, UserDetails{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@Column(nullable = false, unique= true)
	private String email;
	
	private String senha;
	
	@Column(nullable = false, unique=true)
	private String cpf;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private UserRole userRole;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Set<AluguelSala> alugueis = new HashSet<>();
	
	public Usuario() {}
	
	public Usuario(Long id, String nome, String email, String senha, String cpf, UserRole userRole) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.userRole = userRole;
	}
	
	public Usuario(String nome, String email, String senha, String cpf, UserRole userRole) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.userRole = userRole;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Set<AluguelSala> getAlugueis() {
		return alugueis;
	}
	
	public void setAlugueis(Set<AluguelSala> alugueis) {
		this.alugueis = alugueis;
	}

	public UserRole getUserRole() {
	    return userRole;
	}

	public void setUserRole(UserRole userRole) {
	    this.userRole = userRole;
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
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		if(this.userRole == UserRole.ADMIN) 
		{
			return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
		}
		
		return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
	    return senha;
	}
	@Override
	public String getUsername() {
	    return email;
	}
	
}
