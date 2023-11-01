package com.prova.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.data.domain.Page;*/
/*import org.springframework.data.domain.Pageable;*/
/*import org.springframework.data.web.PageableDefault;*/
/*import org.springframework.http.ResponseEntity;
/*import org.springframework.transaction.annotation.Transactional;*/
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*import org.springframework.web.util.UriComponentsBuilder;*/

import com.prova.demo.domain.usuario.Usuario;
import com.prova.demo.repository.UsuarioRepository;


@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> getAllUsuario() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .orElse(null);
    }

    @PostMapping
    public Usuario addUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        if (usuarioRepository.existsById(id)) {
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }

    /*@Autowired
  private UsuarioRepository repository;

  @PostMapping
    @Transactional
    public ResponseEntity<Object> cadastrar(@RequestBody Usuario usuario,
        UriComponentsBuilder uriBuilder) {
        Usuario usuarioLocal = repository.save(usuario);
        var uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuarioLocal.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> detalhar(@PathVariable Long id) {
        Usuario usuario = repository.getReferenceById(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<Page<Usuario>> listar(@PageableDefault(size = 30, sort = { "nome" }) Pageable paginacao) {
        var usuarios = repository.findAll(paginacao);
        return ResponseEntity.ok(usuarios);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> excluir(@PathVariable Long id) {
        var usuario = repository.getReferenceById(id);
        repository.delete(usuario);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario) {
        Usuario usuarioLocal = repository.findById(
                usuario.getId()).get();

        usuarioLocal.setNome(usuario.getNome());

        return ResponseEntity.ok(usuarioLocal);
    }*/
}
