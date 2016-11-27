package br.cesed.si.tap.projeto.sboot.interfaces;

import java.io.IOException;

public class AlunoCadastradoException extends IOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5162133541852901365L;
	
	public AlunoCadastradoException() {
		super("Usuário Já Foi Cadastrado");
	}

}
