package br.cesed.si.tap.projeto.sboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.cesed.si.tap.projeto.sboot.domain.Pesquisa;

public interface PesquisaRepository extends MongoRepository<Pesquisa, String>{

	public Pesquisa findById(int id);
}
