package br.cesed.si.tap.projeto.sboot.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.cesed.si.tap.projeto.sboot.domain.Funcionario;
import br.cesed.si.tap.projeto.sboot.repository.FuncionarioRepository;

@Service
@Validated
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public Funcionario getById(String id){
		return funcionarioRepository.findOne(id);
	}
	
	public List<Funcionario> listTodosOsFuncionarios() {
		return funcionarioRepository.findAll();
	}
	
	public Funcionario save(@NotNull Funcionario funcionario){
		Funcionario existing = funcionarioRepository.findById(funcionario.getId());
		if(existing == null)
			existing = funcionarioRepository.save(funcionario);
		return existing;
	}
	
	public void deletaFuncionario(Funcionario funcionario){
		Funcionario existing = funcionarioRepository.findById(funcionario.getId());
		if(existing != null)
			funcionarioRepository.delete(existing);
	}
	
	public FuncionarioRepository getRepository(){
		return funcionarioRepository;
	}
}
