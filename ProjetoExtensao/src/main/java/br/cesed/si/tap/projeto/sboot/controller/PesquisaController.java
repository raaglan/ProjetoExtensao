package br.cesed.si.tap.projeto.sboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.cesed.si.tap.projeto.sboot.domain.Pesquisa;
import br.cesed.si.tap.projeto.sboot.service.PesquisaService;

@RestController
public class PesquisaController {

	private PesquisaService pesquisaService;
	
	@RequestMapping(value="/pesquisa", method = RequestMethod.GET)
	public ResponseEntity< List<Pesquisa> > ListTodosAsPesquisas(){
		
		return new ResponseEntity< List<Pesquisa> >
		(pesquisaService.listTodosAsPesquisas(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/pesquisa/{id}", method = RequestMethod.GET)
	public ResponseEntity <Pesquisa> getPesquisa(@PathVariable String id){
	
		Pesquisa pesquisa = pesquisaService.getById(id);
		
		return pesquisa == null ? 
				new ResponseEntity<Pesquisa>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Pesquisa>(pesquisa, HttpStatus.OK);
	}
	
	@RequestMapping(value="/pesquisa", method = RequestMethod.POST)
	public ResponseEntity<String> criandoPesquisa(@RequestBody Pesquisa pesquisa) {
		try {
			pesquisaService.save(pesquisa);
			return new ResponseEntity<String>(HttpStatus.CREATED);

		 } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/pesquisa/{id}", method = RequestMethod.DELETE)
	public String deletandoPesquisa (@PathVariable String id){
		
		Pesquisa pesquisa = pesquisa.getById(id);
		pesquisaService.deletaPesquisa (pesquisa);
		return "Pesquisa deletada " + id;
	}
	
	public PesquisaService getPesquisaService() {
		return pesquisaService;
	}
}
