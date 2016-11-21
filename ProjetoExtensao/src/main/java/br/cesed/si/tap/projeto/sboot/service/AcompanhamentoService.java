package br.cesed.si.tap.projeto.sboot.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.cesed.si.tap.projeto.sboot.domain.Acompanhamento;
import br.cesed.si.tap.projeto.sboot.repository.AcompanhamentoRepository;

@Service
@Validated
public class AcompanhamentoService {

	@Autowired
	private AcompanhamentoRepository acompanhamentoRepository;
	
	public Acompanhamento getById(String id){
		return acompanhamentoRepository.findOne(id);
	}
	
	public List<Acompanhamento> listTodosOsAcompanhamentos() {
		return acompanhamentoRepository.findAll();
	}
	
	public Acompanhamento save(@NotNull Acompanhamento acompanhamento){
		Acompanhamento existing = acompanhamentoRepository.findById(acompanhamento.getId());
		if(existing == null)
			existing = acompanhamentoRepository.save(acompanhamento);
		return existing;
	}
	
	public void deletaAcompanhamento(Acompanhamento acompanhamento){
		Acompanhamento existing = acompanhamentoRepository.findById(acompanhamento.getId());
		if(existing != null)
			acompanhamentoRepository.delete(existing);
	}
	
	public AcompanhamentoRepository getRepository(){
		return acompanhamentoRepository;
	}
}
