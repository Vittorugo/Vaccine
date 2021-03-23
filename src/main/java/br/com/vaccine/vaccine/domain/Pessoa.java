package br.com.vaccine.vaccine.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo;
    private String nome;
    private Integer idade;
    private String cpf;
    private String telefone;
    private String email;
    private String dataNascimento;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(codigo, pessoa.codigo) && Objects.equals(nome, pessoa.nome) && Objects.equals(idade, pessoa.idade) && Objects.equals(cpf, pessoa.cpf) && Objects.equals(telefone, pessoa.telefone) && Objects.equals(email, pessoa.email) && Objects.equals(dataNascimento, pessoa.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome, idade, cpf, telefone, email, dataNascimento);
    }
}
