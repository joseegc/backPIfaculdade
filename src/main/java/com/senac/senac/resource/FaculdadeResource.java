package com.senac.senac.resource;

import com.senac.senac.entities.Aluno;
import com.senac.senac.services.FaculdadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/faculdade")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:58386"})

public class FaculdadeResource {

    @Autowired
    private FaculdadeService faculdadeService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Integer id) {
        Aluno aluno = faculdadeService.findById(id);
        return ResponseEntity.ok().body(aluno);
    }

    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<Aluno> findByNome(@PathVariable String nome) {
        Aluno aluno = faculdadeService.findByNome(nome);
        return ResponseEntity.ok().body(aluno);
    }

    @GetMapping(value = "/abertos")
    public ResponseEntity<List<Aluno>> listarAbertos() {
        List<Aluno> alunos = faculdadeService.listarTodosAbertos();

        return ResponseEntity.ok().body(alunos);
    }

    @GetMapping(value = "/fechados")
    public ResponseEntity<List<Aluno>> listarFechados() {
        List<Aluno> alunos = faculdadeService.listarTodosFechados();

        return ResponseEntity.ok().body(alunos);
    }

    // READ
    @GetMapping
    public List<Aluno> findAll() {
        List<Aluno> aluno = faculdadeService.findAll();
        return aluno;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Aluno> gravarAluno(@RequestBody Aluno aluno) {
       aluno = faculdadeService.gravarAluno(aluno);
       URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{ra}").buildAndExpand(aluno.getRa()).toUri();

       return ResponseEntity.created(uri).body(aluno);
    }

    // DELETE
    @DeleteMapping(value = "/{ra}")
    public ResponseEntity<Void> deletar(@PathVariable Integer ra){
        faculdadeService.deletar(ra);
        return ResponseEntity.noContent().build();
    }

    // UPDATE
    @PutMapping(value = "/{ra}")
    public ResponseEntity<Void> update(@PathVariable Integer ra, @RequestBody Aluno aluno) {
    Aluno alterado = faculdadeService.update(ra, aluno);

        return ResponseEntity.noContent().build();
    }

}
