package br.cesed.si.tap.projeto.sboot.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class Pesquisa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Field
	private String descricao;
	@Field
	private String categoria;
	@Id
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Pesquisa(){
		
	}
	
	public Pesquisa (String descricao, String categoria){
		this.descricao = descricao;
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
