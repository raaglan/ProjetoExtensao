package br.cesed.si.tap.projeto.sboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.cesed.si.tap.projeto.sboot.domain.Curso;
import br.cesed.si.tap.projeto.sboot.service.CursoService;

@RestController
public class CursoController {

	private CursoService cursoService;
	
	@RequestMapping(value="/curso", method = RequestMethod.GET)
	public ResponseEntity< List<Curso> > ListTodosOsCursos(){
		
		return new ResponseEntity< List<Curso> >
		(cursoService.listTodosOsCursos(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/curso/{id}", method = RequestMethod.GET)
	public ResponseEntity <Curso> getCurso(@PathVariable String id){
	
		Curso curso = cursoService.getById(id);
		
		return curso == null ? 
				new ResponseEntity<Curso>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Curso>(curso, HttpStatus.OK);
	}
	
	@RequestMapping(value="/curso", method = RequestMethod.POST)
	public ResponseEntity<String> criandoCurso(@RequestBody Curso curso) {
		try {
			cursoService.save(curso);
			return new ResponseEntity<String>(HttpStatus.CREATED);

		 } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/curso/{id}", method = RequestMethod.DELETE)
	public String deletandoCurso (@PathVariable String id){
		
		Curso curso = curso.getById(id);
		cursoService.deletaCurso (curso);
		return "Curso deletado " + id;
	}
	
	public CursoService getCursoService() {
		return cursoService;
	}
}

