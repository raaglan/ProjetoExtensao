package br.cesed.si.tap.projeto.sboot.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

public class Pesquisa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Field
	private String descricao;
	@Field
	private Enum<?> categoria;
	
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pesquisa(){
		
	}
	
	public Pesquisa (String descricao, Enum<?> categoria){
		this.descricao = descricao;
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Enum<?> getCategoria() {
		return categoria;
	}

	public void setCategoria(Enum<?> categoria) {
		this.categoria = categoria;
	}
	
}
