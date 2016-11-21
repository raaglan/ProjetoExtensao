package br.cesed.si.tap.projeto.sboot.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.cesed.si.tap.projeto.sboot.domain.Usuario;
import br.cesed.si.tap.projeto.sboot.repository.UsuarioRepository;

@Service
@Validated
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario getById(String id){
		return usuarioRepository.findOne(id);
	}
	
	public List<Usuario> listTodosOsUsuarios() {
		return usuarioRepository.findAll();
	}
	
	public Usuario save(@NotNull Usuario usuario){
		Usuario existing = usuarioRepository.findById(usuario.getId());
		if(existing == null)
			existing = usuarioRepository.save(usuario);
		return existing;
	}
	
	public void deletaUsuario(Usuario usuario){
		Usuario existing = usuarioRepository.findById(usuario.getId());
		if(existing != null)
			usuarioRepository.delete(existing);
	}
	
	public UsuarioRepository getRepository(){
		return usuarioRepository;
	}
}