package br.cesed.si.tap.projeto.sboot.domain;


import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Funcionario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	private String id;
	
	public Funcionario(){
		
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}	
}
