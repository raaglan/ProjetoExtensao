package br.cesed.si.tap.projeto.sboot.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class Curso implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Field
	private String nome;
	@Id
	private String id;
	
	public Curso(){
		
	}
	
	public Curso(String nome, String id){
		this.nome = nome;
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
}
