package br.ifpe.jaboatao.padaria.models;

public class Cliente extends Pessoa {
    private int idCliente;
    private String telefone;
    private String cpf;
    
    public Cliente() {
        super();
    }

    public Cliente(int idCliente, String nome, String telefone, String cpf) {
        super(nome);
        this.idCliente = idCliente;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public int getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public void exibirDados() {
        System.out.println("Cliente: " + getNome() + " | CPF: " + this.cpf + " | Tel: " + this.telefone);
    }
}