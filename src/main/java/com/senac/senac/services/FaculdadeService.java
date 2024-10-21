package com.senac.senac.services;

import com.senac.senac.entities.Aluno;
import com.senac.senac.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaculdadeService {
    @Autowired
    AlunoRepository alunoRepository;

    public Aluno findById(Integer ra) {
        Optional<Aluno> aluno = alunoRepository.findById(ra);
        return aluno.orElse(null);
    }

    public Aluno findByNome(String nome) {
        List<Aluno> alunos = alunoRepository.findByNome(nome);

        if (!alunos.isEmpty()) {
            return alunos.get(0); // Retorna o primeiro aluno se existir
        }
        return null; // Retorna null se não houver alunos com esse nome
    }

    public List<Aluno> listarTodosAbertos() {
        List<Aluno> alunos = alunoRepository.listarTodosAbertos();
        return alunos;
    }

    public List<Aluno> listarTodosFechados() {
        List<Aluno> alunos = alunoRepository.listarTodosFechados();
        return alunos;
    }

    public List<Aluno> findAll() {
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos;
    }

    public Aluno gravarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public void deletar(Integer ra) {
        alunoRepository.deleteById(ra);
    }

    public Aluno update(Integer ra, Aluno aluno) {
        Aluno alterado = findById(ra);
        if (alterado != null) {
            alterado.setNome(aluno.getNome());
            alterado.setDataCadastro(aluno.getDataCadastro());
            alterado.setAtivo(aluno.isAtivo());
            return alunoRepository.save(alterado);
        }
        return null;
    }

}
