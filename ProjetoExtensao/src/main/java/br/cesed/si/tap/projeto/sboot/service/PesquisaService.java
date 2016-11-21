package br.cesed.si.tap.projeto.sboot.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.cesed.si.tap.projeto.sboot.domain.Pesquisa;
import br.cesed.si.tap.projeto.sboot.repository.PesquisaRepository;

@Service
@Validated
public class PesquisaService {

	@Autowired
	private PesquisaRepository pesquisaRepository;
	
	public Pesquisa getById(String id){
		return pesquisaRepository.findOne(id);
	}
	
	public List<Pesquisa> listTodasAsPesquisas() {
		return pesquisaRepository.findAll();
	}
	
	public Pesquisa save(@NotNull Pesquisa pesquisa){
		Pesquisa existing = pesquisaRepository.findById(pesquisa.getId());
		if(existing == null)
			existing = pesquisaRepository.save(pesquisa);
		return existing;
	}
	
	public void deletaPesquisa(Pesquisa pesquisa){
		Pesquisa existing = pesquisaRepository.findById(pesquisa.getId());
		if(existing != null)
			pesquisaRepository.delete(existing);
	}
	
	public PesquisaRepository getRepository(){
		return pesquisaRepository;
	}
}

