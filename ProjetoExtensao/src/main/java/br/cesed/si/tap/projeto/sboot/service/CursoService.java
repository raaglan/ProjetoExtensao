package br.cesed.si.tap.projeto.sboot.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.cesed.si.tap.projeto.sboot.domain.Curso;
import br.cesed.si.tap.projeto.sboot.repository.CursoRepository;

@Service
@Validated
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	public Curso getById(String id){
		return cursoRepository.findOne(id);
	}
	
	public List<Curso> listTodosOsCursos() {
		return cursoRepository.findAll();
	}
	
	public Curso save(@NotNull Curso curso){
		Curso existing = cursoRepository.findById(curso.getId());
		if(existing == null)
			existing = cursoRepository.save(curso);
		return existing;
	}
	
	public void deletaCurso(Curso curso){
		Curso existing = cursoRepository.findById(curso.getId());
		if(existing != null)
			cursoRepository.delete(existing);
	}
	
	public CursoRepository getRepository(){
		return cursoRepository;
	}
}
