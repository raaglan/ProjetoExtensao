package br.cesed.si.tap.projeto.sboot.domain;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class Aluno implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Field
	private String nome;
	@Field
	private String matricula;
	@Field
	private ArrayList<Curso> curso;
	@Id
	private String id;
	
	public Aluno(){
		
	}
	
	public Aluno(String nome, String matricula, ArrayList<Curso> curso){
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
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

	public ArrayList<Curso> getCurso() {
		return curso;
	}

	public void setCurso(ArrayList<Curso> curso) {
		this.curso = curso;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
