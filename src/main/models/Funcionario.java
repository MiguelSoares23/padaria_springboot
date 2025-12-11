package br.ifpe.jaboatao.padaria.models;

import java.util.List;
import java.util.ArrayList;

public class Funcionario extends Pessoa {
    private int idFuncionario;
    private String cargo;
    private float salario;
    private List<Cliente> clientesAtendidos;

    public Funcionario() {
        super();
        this.clientesAtendidos = new ArrayList<>();
    }

    public Funcionario(int idFuncionario, String nome, String cargo, float salario) {
        super(nome);
        this.idFuncionario = idFuncionario;
        this.cargo = cargo;
        this.salario = salario;
        this.clientesAtendidos = new ArrayList<>();
    }

    public int getIdFuncionario() {
        return this.idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getSalario() {
        return this.salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public List<Cliente> getClientesAtendidos() {
        return this.clientesAtendidos;
    }

    public void setClientesAtendidos(List<Cliente> clientesAtendidos) {
        this.clientesAtendidos = clientesAtendidos;
    }

    @Override
    public void exibirDados() {
        System.out.println("Funcionario: " + getNome() + " | Cargo: " + this.cargo + " | Salário: " + this.salario);
    }

    public void registrarVenda(Cliente cliente, Produto produto, int qtd) {
        System.out.println("Venda registrada: " + produto.getNome() + " x" + qtd + " para " + cliente.getNome());
    }
}