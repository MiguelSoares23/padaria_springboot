package br.ifpe.jaboatao.padaria.models;

public class Fornecedor {
    private int idFornecedor;
    private String nome;
    private String telefone;
    private String produtoFornecido;

    public Fornecedor() {}

    public Fornecedor(int idFornecedor, String nome, String telefone, String produtoFornecido) {
        this.idFornecedor = idFornecedor;
        this.nome = nome;
        this.telefone = telefone;
        this.produtoFornecido = produtoFornecido;
    }

    public int getIdFornecedor() {
        return this.idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProdutoFornecido() {
        return this.produtoFornecido;
    }

    public void setProdutoFornecido(String produtoFornecido) {
        this.produtoFornecido = produtoFornecido;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void exibirDados() {
        System.out.println("Fornecedor: " + this.nome + " | Telefone: " + this.telefone + " | Produto: " + this.produtoFornecido);
    }
}
