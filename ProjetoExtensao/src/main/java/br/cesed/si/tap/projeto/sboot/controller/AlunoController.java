package br.cesed.si.tap.projeto.sboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.cesed.si.tap.projeto.sboot.domain.Aluno;
import br.cesed.si.tap.projeto.sboot.service.AlunoService;

@RestController
@RequestMapping(value="/aluno")
public class AlunoController {
	@Autowired
	private AlunoService alunoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity< List<Aluno> > ListTodosOsAlunos(){
		
		return new ResponseEntity< List<Aluno> >
		(alunoService.listTodosOsAlunos(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity <Aluno> getAluno(@PathVariable String id){
	
		Aluno aluno = alunoService.getById(id);
		
		return aluno == null ? 
				new ResponseEntity<Aluno>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> criandoAluno(@RequestBody Aluno aluno) {
		try {
			alunoService.save(aluno);
			return new ResponseEntity<String>(HttpStatus.CREATED);

		 } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public String deletandoAluno (@PathVariable Aluno alun){
		

		alunoService.deletaAluno(alun);
		return "Aluno deletado " + alun.getId();
	}
	
	public AlunoService getAlunoService() {
		return alunoService;
	}
}

