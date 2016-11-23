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

import br.cesed.si.tap.projeto.sboot.domain.Curso;
import br.cesed.si.tap.projeto.sboot.service.CursoService;

@RestController
@RequestMapping(value="/curso")
public class CursoController {
	@Autowired
	private CursoService cursoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity< List<Curso> > ListTodosOsCursos(){
		
		return new ResponseEntity< List<Curso> >
		(cursoService.listTodosOsCursos(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity <Curso> getCurso(@PathVariable String id){
	
		Curso curso = cursoService.getById(id);
		
		return curso == null ? 
				new ResponseEntity<Curso>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Curso>(curso, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> criandoCurso(@RequestBody Curso curso) {
		try {
			cursoService.save(curso);
			return new ResponseEntity<String>(HttpStatus.CREATED);

		 } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public String deletandoCurso (@PathVariable Curso cur){
		
		cursoService.deletaCurso(cur);
		return "Curso deletado " + cur.getId();
	}
	
	public CursoService getCursoService() {
		return cursoService;
	}
}

