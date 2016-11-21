package br.cesed.si.tap.projeto.sboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.cesed.si.tap.projeto.sboot.domain.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{
	
	public Usuario findById(int id);

}
