package br.cesed.si.tap.projeto.sboot.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Field
	private String nome;
	@Field
	private String matricula;
	@Field
	private String senha;
	@Field
	private String email;
	@Id
	private String id;
	@Field
	private String nivel;
	
	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public Usuario(){
		
	}
	
	public Usuario(String nome, String matricula, String senha, String email, String id,String nivel){
		this.nome = nome;
		this.matricula = matricula;
		this.senha = senha;
		this.email = email;
		this.id = id;
		this.nivel= nivel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
