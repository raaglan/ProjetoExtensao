package br.cesed.si.tap.projeto.sboot.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

public class Orientacao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Field
	private Aluno aluno;
	@Field
	private Professor professor;
	@Field
	private Pesquisa pesquisa;
	@Field
	private Curso curso;
	
	private int id;
	
	public Orientacao(){
		
	}
	
	public Orientacao(Aluno aluno, Professor professor, Pesquisa pesquisa){
		this.aluno = aluno;
		this.professor = professor;
		this.pesquisa = pesquisa;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Pesquisa getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(Pesquisa pesquisa) {
		this.pesquisa = pesquisa;
	}
	

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
