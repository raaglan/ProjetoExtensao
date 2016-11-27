package br.cesed.si.tap.projeto.sboot.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.cesed.si.tap.projeto.sboot.domain.Professor;

public interface ProfessorRepository extends MongoRepository<Professor, String>{

	public Professor findById(int id);

	public Professor findByNome(String nome);

	public List<Professor> findByCursoNome(String curso);

}
