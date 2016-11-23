package br.cesed.si.tap.projeto.sboot.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class Acompanhamento implements Serializable{

	private static final long serialVersionUID = 1L;

	@Field
	private ArrayList<Orientacao> orientacao;
	@Field
	private Date data;
	@Field
	private Enum<?> status;
	@Field
	private String ocorrencia;
	@Id
	private String id;
	
	public Acompanhamento(){
		
	}
	
	public Acompanhamento(ArrayList<Orientacao> orientacao, Date data, Enum<?> status, String ocorrencia){
		this.orientacao = orientacao;
		this.data = data;
		this.status = status;
		this.ocorrencia = ocorrencia;
	}

	public ArrayList<Orientacao> getOrientacao() {
		return orientacao;
	}

	public void setOrientacao(ArrayList<Orientacao> orientacao) {
		this.orientacao = orientacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Enum<?> getStatus() {
		return status;
	}

	public void setStatus(Enum<?> status) {
		this.status = status;
	}

	public String getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(String ocorrencia) {
		this.ocorrencia = ocorrencia;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
