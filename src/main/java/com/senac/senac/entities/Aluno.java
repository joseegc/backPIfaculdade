package com.senac.senac.entities;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.LogManager;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name="Aluno")
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //FAZ COM QUE O ID SEJA DEFINIDO POR AUTO-INCREMENTO
    @Column(name="ra")
    int ra;

    @Column(name = "Nome")
    String nome;

    @Column(name = "Data de Cadastro")
    Date dataCadastro;

    @Column(name = "ativo")
    boolean ativo;

    public Aluno() {}

    public Aluno(String nome, Date dataCadastro, boolean ativo) {
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.ativo = ativo;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "ra=" + ra +
                ", nome='" + nome + '\'' +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
