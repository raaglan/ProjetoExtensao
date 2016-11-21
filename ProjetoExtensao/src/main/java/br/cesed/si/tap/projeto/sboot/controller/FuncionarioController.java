package br.cesed.si.tap.projeto.sboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.cesed.si.tap.projeto.sboot.domain.Funcionario;
import br.cesed.si.tap.projeto.sboot.service.FuncionarioService;

@RestController
@RequestMapping(value="/funcionario")
public class FuncionarioController {

	private FuncionarioService funcionarioService;
	
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity< List<Funcionario> > ListTodosOsFuncionarios(){
		
		return new ResponseEntity< List<Funcionario> >
		(funcionarioService.listTodosOsFuncionarios(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity <Funcionario> getFuncionario(@PathVariable String id){
	
		Funcionario funcionario = funcionarioService.getById(id);
		
		return funcionario == null ? 
				new ResponseEntity<Funcionario>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
	}
	
	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<String> criandoFuncionario(@RequestBody Funcionario funcionario) {
		try {
			funcionarioService.save(funcionario);
			return new ResponseEntity<String>(HttpStatus.CREATED);

		 } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public String deletandoFuncionario (@PathVariable String id){
		
		Funcionario funcionario = funcionarioService.getById(id);
		funcionarioService.deletaFuncionario (funcionario);
		return "Funcionario deletado " + id;
	}
	
	public FuncionarioService getFuncionarioService() {
		return funcionarioService;
	}
}
