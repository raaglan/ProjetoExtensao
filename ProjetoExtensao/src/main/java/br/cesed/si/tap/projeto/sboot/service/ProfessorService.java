package br.cesed.si.tap.projeto.sboot.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.cesed.si.tap.projeto.sboot.domain.Professor;
import br.cesed.si.tap.projeto.sboot.repository.ProfessorRepository;

@Service
@Validated
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;
	
	public Professor getById(String id){
		return professorRepository.findOne(id);
	}
	
	public List<Professor> listTodosOsProfessores() {
		return professorRepository.findAll();
	}
	
	public Professor save(@NotNull Professor professor){
		Professor existing = professorRepository.findById(professor.getId());
		if(existing == null)
			existing = professorRepository.save(professor);
		return existing;
	}
	
	public void deletaProfessor(Professor professor){
		Professor existing = professorRepository.findById(professor.getId());
		if(existing != null)
			professorRepository.delete(existing);
	}
	
	public ProfessorRepository getRepository(){
		return professorRepository;
	}
}
