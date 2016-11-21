package br.cesed.si.tap.projeto.sboot.domain;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class Professor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Field
	private ArrayList<Curso> curso;
	@Id
	private String id;
	
	public Professor(){
		
	}
	
	public Professor(ArrayList<Curso> curso){
		this.curso = curso;
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
	
	public void setId(String id){
		this.id = id;
	}
}
