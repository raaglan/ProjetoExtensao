package br.cesed.si.tap.projeto.sboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.cesed.si.tap.projeto.sboot.domain.Orientacao;

public interface OrientacaoRepository extends MongoRepository<Orientacao, String>{

	public Orientacao findByCursoAndProfessor(String curso, String professor);
	
}
