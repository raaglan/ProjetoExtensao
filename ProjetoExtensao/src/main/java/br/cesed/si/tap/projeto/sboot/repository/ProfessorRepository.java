package br.cesed.si.tap.projeto.sboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.cesed.si.tap.projeto.sboot.domain.Professor;

public interface ProfessorRepository extends MongoRepository<Professor, String>{

	public Professor findById(int id);

}
