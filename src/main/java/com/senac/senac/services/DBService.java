package com.senac.senac.services;

import com.senac.senac.entities.Aluno;
import com.senac.senac.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

@Service
public class DBService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Bean
    public void instanciarDB() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Aluno aluno1 = new Aluno("Manoel Gomes", formato.parse("01/08/2024"), true);

        Aluno aluno2 = new Aluno("Manoel Carlos", formato.parse("22/08/2024"), false);

        Aluno aluno3 = new Aluno("Jorge Amado", formato.parse("16/04/2024"), false);

        Aluno aluno4 = new Aluno("Reginaldo Rossi", formato.parse("24/05/2024"), true);

        alunoRepository.saveAll(Arrays.asList(aluno1, aluno2, aluno3, aluno4));
    }
}


