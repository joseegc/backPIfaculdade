package com.senac.senac;

import com.senac.senac.entities.Aluno;
import com.senac.senac.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@SpringBootApplication
public class SenacApplication {
	public static void main(String[] args) {
		SpringApplication.run(SenacApplication.class, args);
	}

}
