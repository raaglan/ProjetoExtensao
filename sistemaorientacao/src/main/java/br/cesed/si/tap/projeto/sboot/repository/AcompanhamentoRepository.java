package br.cesed.si.tap.projeto.sboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.cesed.si.tap.projeto.sboot.domain.Acompanhamento;

public interface AcompanhamentoRepository extends MongoRepository<Acompanhamento, String>{

}
