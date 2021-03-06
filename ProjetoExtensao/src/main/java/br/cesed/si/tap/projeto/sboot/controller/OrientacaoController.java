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

import br.cesed.si.tap.projeto.sboot.domain.Orientacao;
import br.cesed.si.tap.projeto.sboot.service.OrientacaoService;


@RestController
@RequestMapping(value="/orientacao")
public class OrientacaoController {
	@Autowired
	private OrientacaoService orientacaoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity< List<Orientacao> > ListTodosAsOrientacoes(){
		
		return new ResponseEntity< List<Orientacao> >
		(orientacaoService.listTodasAsOrientacoes(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity <Orientacao> getOrientacao(@PathVariable String id){
	
		Orientacao orientacao = orientacaoService.getById(id);
		
		return orientacao == null ? 
				new ResponseEntity<Orientacao>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Orientacao>(orientacao, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> criandoOrientacao(@RequestBody Orientacao orientacao) {
		try {
			orientacaoService.save(orientacao);
			return new ResponseEntity<String>(HttpStatus.CREATED);

		 } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public String deletandoOrientacao (@PathVariable Orientacao ori){
		
		//Orientacao orientacao = orientacao.getId();
		orientacaoService.deletaOrientacao(ori);
		return "Orientacao deletada " + ori.getId();
	}
	
	public OrientacaoService getOrientacaoService() {
		return orientacaoService;
	}
}
