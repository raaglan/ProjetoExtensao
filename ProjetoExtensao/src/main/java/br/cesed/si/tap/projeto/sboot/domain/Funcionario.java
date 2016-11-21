package br.cesed.si.tap.projeto.sboot.domain;


import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

public class Funcionario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Field
	
	private int id;
	
	public Funcionario(){
		
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}	
}
