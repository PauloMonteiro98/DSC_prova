package com.prova.demo.controller;

/*import java.util.List;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.prova.demo.domain.autor.Autor;
import com.prova.demo.repository.AutorRepository;



@RestController
@RequestMapping("autores")
public class AutorController {

    /*@Autowired
    private AutorRepository autorRepository;

    @GetMapping
    public List<Autor> getAllAutor() {
        return autorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Autor getAutorById(@PathVariable Long id) {
        return autorRepository.findById(id)
                .orElse(null);
    }

    @PostMapping
    public Autor addAutor(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }

    @PutMapping("/{id}")
    public Autor updateAutor(@PathVariable Long id, @RequestBody Autor autor) {
        if (autorRepository.existsById(id)) {
            autor.setId(id);
            return autorRepository.save(autor);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteAutor(@PathVariable Long id) {
        autorRepository.deleteById(id);
    }
*/



    
    @Autowired
  private AutorRepository repository;

  @PostMapping
    @Transactional
    public ResponseEntity<Object> cadastrar(@RequestBody Autor autor,
            UriComponentsBuilder uriBuilder) {
        Autor autorLocal = repository.save(autor);
        var uri = uriBuilder.path("/autor/{id}").buildAndExpand(autorLocal.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> detalhar(@PathVariable Long id) {
        Autor autor = repository.getReferenceById(id);
        return ResponseEntity.ok(autor);
    }

    @GetMapping
    public ResponseEntity<Page<Autor>> listar(@PageableDefault(size = 30, sort = { "nome" }) Pageable paginacao) {
        var autores = repository.findAll(paginacao);
        return ResponseEntity.ok(autores);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> excluir(@PathVariable Long id) {
        var autor = repository.getReferenceById(id);
        repository.delete(autor);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Autor> atualizar(@RequestBody Autor autor) {
        Autor autorLocal = repository.findById(
                autor.getId()).get();

        autorLocal.setNome(autor.getNome());

        return ResponseEntity.ok(autorLocal);
    }

}
