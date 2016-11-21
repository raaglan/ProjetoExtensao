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

import br.cesed.si.tap.projeto.sboot.domain.Usuario;
import br.cesed.si.tap.projeto.sboot.service.UsuarioService;

@RestController
@RequestMapping(value="/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity< List<Usuario> > ListTodosOsUsuarios(){
		
		return new ResponseEntity< List<Usuario> >
		(usuarioService.listTodosOsUsuarios(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity <Usuario> getUsuario(@PathVariable String id){
	
		Usuario usuario = usuarioService.getById(id);
		
		return usuario == null ? 
				new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> criandoUsuario(@RequestBody Usuario usuario) {
		try {
			usuarioService.save(usuario);
			return new ResponseEntity<String>(HttpStatus.CREATED);

		 } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public String deletandoUsuario (@PathVariable Usuario user){
		
		usuarioService.deletaUsuario (user);
		return "Usuario deletado " + user.getId();
	}
	
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}
}

