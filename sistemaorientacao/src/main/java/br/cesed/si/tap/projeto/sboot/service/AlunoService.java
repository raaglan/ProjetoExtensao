package br.cesed.si.tap.projeto.sboot.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.cesed.si.tap.projeto.sboot.domain.Aluno;
import br.cesed.si.tap.projeto.sboot.repository.AlunoRepository;

@Service
@Validated
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	public Aluno getById(String id){
		return alunoRepository.findOne(id);
	}
	
	public List<Aluno> listTodosOsAlunos() {
		return alunoRepository.findAll();
	}
	
	public Aluno save(@NotNull Aluno aluno){
		Aluno existing = alunoRepository.findByNomeAndMatricula(aluno.getNome(), aluno.getMatricula());
		if(existing == null){
			existing = alunoRepository.save(aluno);
			return existing;
		}
		return existing = null;	
		
	}
	
	public void deletaAluno(Aluno aluno){
		Aluno existing = alunoRepository.findOne(aluno.getId());
		if(existing != null)
			alunoRepository.delete(existing);
	}
	
	public AlunoRepository getRepository(){
		return alunoRepository;
	}
}
