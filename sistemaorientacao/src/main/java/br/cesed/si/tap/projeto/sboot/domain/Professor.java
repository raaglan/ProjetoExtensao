package br.cesed.si.tap.projeto.sboot.domain;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Field;

public class Professor extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Field
	private ArrayList<Curso> curso;

	public Professor() {

	}

	public Professor(String nome, String matricula, String senha, String email, String id, String nivel,ArrayList<Curso> curso) {
		super(nome, matricula, senha, email, id, nivel);
		this.curso= curso;
		
	}

	public Professor(ArrayList<Curso> curso) {
		this.curso = curso;
	}

	public ArrayList<Curso> getCurso() {
		return curso;
	}

	public void setCurso(ArrayList<Curso> curso) {
		this.curso = curso;
	}

}
