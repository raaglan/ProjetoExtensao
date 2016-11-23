package br.cesed.si.tap.projeto.sboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.cesed.si.tap.projeto.sboot.domain.Curso;

public interface CursoRepository extends MongoRepository<Curso, String>{

	public Curso findById(int id);
}
