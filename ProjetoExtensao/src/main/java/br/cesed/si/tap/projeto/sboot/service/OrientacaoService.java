package br.cesed.si.tap.projeto.sboot.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.cesed.si.tap.projeto.sboot.domain.Orientacao;
import br.cesed.si.tap.projeto.sboot.repository.OrientacaoRepository;

@Service
@Validated
public class OrientacaoService {

	@Autowired
	private OrientacaoRepository orientacaoRepository;
	
	public Orientacao getById(String id){
		return orientacaoRepository.findOne(id);
	}
	
	public List<Orientacao> listTodasAsOrientacoes() {
		return orientacaoRepository.findAll();
	}
	
	public Orientacao save(@NotNull Orientacao orientacao){
		Orientacao existing = orientacaoRepository.findOne(orientacao.getId());
		if(existing == null)
			existing = orientacaoRepository.save(orientacao);
		return existing;
	}
	
	public void deletaOrientacao(Orientacao orientacao){
		Orientacao existing = orientacaoRepository.findOne(orientacao.getId());
		if(existing != null)
			orientacaoRepository.delete(existing);
	}
	
	public OrientacaoRepository getRepository(){
		return orientacaoRepository;
	}
}

