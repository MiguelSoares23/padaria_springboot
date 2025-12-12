package br.ifpe.jaboatao.padaria.models;

import java.util.ArrayList;
import java.util.List;

public class Padaria {
    private int idPadaria;
    private String nome;
    private String endereco;
    private List<Funcionario> funcionarios;
    private List<Fornecedor> fornecedores;

    public Padaria() {
        this.funcionarios = new ArrayList<>();
        this.fornecedores = new ArrayList<>();
    }

    public Padaria(int idPadaria, String nome, String endereco) {
        this.idPadaria = idPadaria;
        this.nome = nome;
        this.endereco = endereco;
        this.funcionarios = new ArrayList<>();
        this.fornecedores = new ArrayList<>();
    }

    public int getIdPadaria() {
        return this.idPadaria;
    }

    public void setIdPadaria(int idPadaria) {
        this.idPadaria = idPadaria;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Fornecedor> getFornecedores() {
        return this.fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    public void adcFuncionario(Funcionario f) {
        funcionarios.add(f);
    }

    public void adcFornecedor(Fornecedor f) {
        fornecedores.add(f);
    }

    public void listarFuncionarios() {
        funcionarios.forEach(Funcionario::exibirDados);
    }

    public void listarFornecedores() {
        fornecedores.forEach(Fornecedor::exibirDados);
    }
}