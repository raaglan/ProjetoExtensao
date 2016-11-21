package br.cesed.si.tap.projeto.sboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.cesed.si.tap.projeto.sboot.domain.Professor;
import br.cesed.si.tap.projeto.sboot.service.ProfessorService;

@RestController
public class ProfessorController {

	private ProfessorService professorService;
	
	@RequestMapping(value="/professor", method = RequestMethod.GET)
	public ResponseEntity< List<Professor> > ListTodosOsProfessores(){
		
		return new ResponseEntity< List<Professor> >
		(professorService.listTodosOsProfessores(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/professor/{id}", method = RequestMethod.GET)
	public ResponseEntity <Professor> getProfessor(@PathVariable String id){
	
		Professor professor = professorService.getById(id);
		
		return professor == null ? 
				new ResponseEntity<Professor>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Professor>(professor, HttpStatus.OK);
	}
	
	@RequestMapping(value="/professor", method = RequestMethod.POST)
	public ResponseEntity<String> criandoProfessor(@RequestBody Professor professor) {
		try {
			professorService.save(professor);
			return new ResponseEntity<String>(HttpStatus.CREATED);

		 } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/professor/{id}", method = RequestMethod.DELETE)
	public String deletandoProfessor (@PathVariable String id){
		
		Professor professor = professorService.getById(id);
		professorService.deletaProfessor (professor);
		return "Professor deletado " + id;
	}
	
	public ProfessorService getProfessorService() {
		return professorService;
	}
}
