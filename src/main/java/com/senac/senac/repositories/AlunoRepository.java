package com.senac.senac.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.senac.senac.entities.Aluno;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    @Query("SELECT alunos FROM Aluno alunos WHERE alunos.nome LIKE ?1")
    List<Aluno> findByNome(String nome);

    @Query("SELECT alunos FROM Aluno alunos WHERE alunos.ativo=true ORDER BY alunos.nome")
    List<Aluno> listarTodosAbertos();

    @Query("SELECT alunos FROM Aluno alunos WHERE alunos.ativo=false ORDER BY alunos.nome")
    List<Aluno> listarTodosFechados();
}
