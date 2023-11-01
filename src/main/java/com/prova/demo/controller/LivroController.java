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

import com.prova.demo.domain.livro.Livro;
import com.prova.demo.repository.LivroRepository;

@RestController
@RequestMapping("livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public List<Livro> getAllLivro() {
        return livroRepository.findAll();
    }

    @GetMapping("/{id}")
    public Livro getLivroById(@PathVariable Long id) {
        return livroRepository.findById(id)
                .orElse(null);
    }

    @PostMapping
    public Livro addLivro(@RequestBody Livro livro) {
        return livroRepository.save(livro);
    }

    @PutMapping("/{id}")
    public Livro updateLivro(@PathVariable Long id, @RequestBody Livro livro) {
        if (livroRepository.existsById(id)) {
            livro.setId(id);
            return livroRepository.save(livro);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteLivro(@PathVariable Long id) {
        livroRepository.deleteById(id);
    }

  /*@Autowired
  private LivroRepository repository;

  @PostMapping
    @Transactional
    public ResponseEntity<Object> cadastrar(@RequestBody Livro livro,
        UriComponentsBuilder uriBuilder) {
        Livro livroLocal = repository.save(livro);
        var uri = uriBuilder.path("/livro/{id}").buildAndExpand(livroLocal.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> detalhar(@PathVariable Long id) {
        Livro livro = repository.getReferenceById(id);
        return ResponseEntity.ok(livro);
    }

    @GetMapping
    public ResponseEntity<Page<Livro>> listar(@PageableDefault(size = 30, sort = { "nome" }) Pageable paginacao) {
        var livros = repository.findAll(paginacao);
        return ResponseEntity.ok(livros);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> excluir(@PathVariable Long id) {
        var livro = repository.getReferenceById(id);
        repository.delete(livro);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Livro> atualizar(@RequestBody Livro livro) {
        Livro livroLocal = repository.findById(
                livro.getId()).get();

        livroLocal.setTitulo(livro.getTitulo());

        return ResponseEntity.ok(livroLocal);
    }*/
}
