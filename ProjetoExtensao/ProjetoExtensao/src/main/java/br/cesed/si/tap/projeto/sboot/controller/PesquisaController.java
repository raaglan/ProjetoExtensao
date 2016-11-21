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

import br.cesed.si.tap.projeto.sboot.domain.Pesquisa;
import br.cesed.si.tap.projeto.sboot.service.PesquisaService;

@RestController
@RequestMapping(value="/pesquisa")
public class PesquisaController {
	@Autowired
	private PesquisaService pesquisaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity< List<Pesquisa> > ListTodosAsPesquisas(){
		
		return new ResponseEntity< List<Pesquisa> >
		(pesquisaService.listTodasAsPesquisas(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity <Pesquisa> getPesquisa(@PathVariable String id){
	
		Pesquisa pesquisa = pesquisaService.getById(id);
		
		return pesquisa == null ? 
				new ResponseEntity<Pesquisa>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Pesquisa>(pesquisa, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> criandoPesquisa(@RequestBody Pesquisa pesquisa) {
		try {
			pesquisaService.save(pesquisa);
			return new ResponseEntity<String>(HttpStatus.CREATED);

		 } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public String deletandoPesquisa (@PathVariable Pesquisa pesq){
		
		pesquisaService.deletaPesquisa (pesq);
		return "Pesquisa deletada " + pesq.getId();
	}
	
	public PesquisaService getPesquisaService() {
		return pesquisaService;
	}
}
