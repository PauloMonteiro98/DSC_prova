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

import com.prova.demo.domain.emprestimo.Emprestimo;
import com.prova.demo.repository.EmprestimoRepository;

@RestController
@RequestMapping("emprestimos")
public class EmprestimoController {
  
    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @GetMapping
    public List<Emprestimo> getAllAutor() {
        return emprestimoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Emprestimo getAutorById(@PathVariable Long id) {
        return emprestimoRepository.findById(id)
                .orElse(null);
    }

    @PostMapping
    public Emprestimo addEmprestimo(@RequestBody Emprestimo emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }

    @PutMapping("/{id}")
    public Emprestimo updateEmprestimo(@PathVariable Long id, @RequestBody Emprestimo emprestimo) {
        if (emprestimoRepository.existsById(id)) {
            emprestimo.setId(id);
            return emprestimoRepository.save(emprestimo);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteEmprestimo(@PathVariable Long id) {
        emprestimoRepository.deleteById(id);
    }


  /*@Autowired
  private EmprestimoRepository repository;

  @PostMapping
    @Transactional
    public ResponseEntity<Object> cadastrar(@RequestBody Emprestimo emprestimo,
        UriComponentsBuilder uriBuilder) {
        Emprestimo emprestimoLocal = repository.save(emprestimo);
        var uri = uriBuilder.path("/emprestimo/{id}").buildAndExpand(emprestimoLocal.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> detalhar(@PathVariable Long id) {
        Emprestimo emprestimo = repository.getReferenceById(id);
        return ResponseEntity.ok(emprestimo);
    }

    @GetMapping
    public ResponseEntity<Page<Emprestimo>> listar(@PageableDefault(size = 30, sort = { "nome" }) Pageable paginacao) {
        var emprestimos = repository.findAll(paginacao);
        return ResponseEntity.ok(emprestimos);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> excluir(@PathVariable Long id) {
        var emprestimo = repository.getReferenceById(id);
        repository.delete(emprestimo);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Emprestimo> atualizar(@RequestBody Emprestimo emprestimo) {
        Emprestimo emprestimoLocal = repository.findById(
                emprestimo.getId()).get();

        emprestimoLocal.setId(emprestimo.getId());

        return ResponseEntity.ok(emprestimoLocal);
    }*/
}
