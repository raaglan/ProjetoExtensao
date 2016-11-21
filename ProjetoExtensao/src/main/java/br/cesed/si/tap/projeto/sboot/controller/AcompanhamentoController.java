package br.cesed.si.tap.projeto.sboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.cesed.si.tap.projeto.sboot.domain.Acompanhamento;
import br.cesed.si.tap.projeto.sboot.service.AcompanhamentoService;


@RestController
@RequestMapping(value="/acompanhamento")
public class AcompanhamentoController {

	private AcompanhamentoService acompanhamentoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity< List<Acompanhamento> > ListTodosOsAcompanhamentos(){
		
		return new ResponseEntity< List<Acompanhamento> >
		(acompanhamentoService.listTodosOsAcompanhamentos(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity <Acompanhamento> getAcompanhamento(@PathVariable String id){
	
		Acompanhamento acompanhamento = acompanhamentoService.getById(id);
		
		return acompanhamento == null ? 
				new ResponseEntity<Acompanhamento>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Acompanhamento>(acompanhamento, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> criandoAcompanhamento(@RequestBody Acompanhamento acompanhamento) {
		try {
			acompanhamentoService.save(acompanhamento);
			return new ResponseEntity<String>(HttpStatus.CREATED);

		 } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public String deletandoAcomapanhamento (@PathVariable Acompanhamento aco){
		
		acompanhamentoService.deletaAcompanhamento(aco);
		return "Acompanhamento deletado ";
	}
	
	public AcompanhamentoService getFuncionarioService() {
		return acompanhamentoService;
	}
}
