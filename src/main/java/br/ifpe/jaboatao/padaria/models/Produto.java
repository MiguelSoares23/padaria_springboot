package br.ifpe.jaboatao.padaria.models;

public class Produto {
    private int idProduto;
    private String nome;
    private float preco;
    private int qtdEstoque;
    private String categoria;

    public Produto() {}

    public Produto(int idProduto, String nome, float preco, int qtdEstoque, String categoria) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
        this.categoria = categoria;
    }

    public int getIdProduto() {
        return this.idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return this.preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQtdEstoque() {
        return this.qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void reporEstoque(int qtd) {
        qtdEstoque += qtd;
    }

    public void retirarEstoque(int qtd) {
        if (qtd <= qtdEstoque) {
            qtdEstoque -= qtd;
        } else {
            System.out.println("Estoque insuficiente!");
        }
    }
}