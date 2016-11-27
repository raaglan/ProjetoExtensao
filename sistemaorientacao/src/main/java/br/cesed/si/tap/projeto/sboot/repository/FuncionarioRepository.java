package br.cesed.si.tap.projeto.sboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.cesed.si.tap.projeto.sboot.domain.Funcionario;

public interface FuncionarioRepository extends MongoRepository<Funcionario, String>{

	public Funcionario findById(int id);

}
