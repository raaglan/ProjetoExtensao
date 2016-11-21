package br.cesed.si.tap.projeto.sboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.cesed.si.tap.projeto.sboot.domain.Orientacao;

public interface OrientacaoRepository extends MongoRepository<Orientacao, Integer>{

	public Orientacao findByCursoAndProfessor(String curso, String professor);
	public Orientacao findById(int id);
}
