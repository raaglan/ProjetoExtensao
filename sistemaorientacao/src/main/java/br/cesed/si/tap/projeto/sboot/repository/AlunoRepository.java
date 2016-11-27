package br.cesed.si.tap.projeto.sboot.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.cesed.si.tap.projeto.sboot.domain.Aluno;

public interface AlunoRepository extends MongoRepository<Aluno, String>{
	
	Aluno findByNome(String nome);
	Aluno findByNomeAndMatricula(String nome,String matricula);
	List<Aluno> findByCursoNome(String curso);

}
