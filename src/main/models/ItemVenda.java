package br.ifpe.jaboatao.padaria.models;

public class ItemVenda {
    private int idItemVenda;
    private int idVenda;
    private int idProduto;
    private int qtd;
    private float precoUnidade;
    private float subtotal;

    public ItemVenda() {}

    public ItemVenda(int idItemVenda, int idVenda, int idProduto, int qtd, float precoUnidade) {
        this.idItemVenda = idItemVenda;
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.qtd = qtd;
        this.precoUnidade = precoUnidade;
        calcularSubtotal();
    }

    public int getIdItemVenda() {
        return this.idItemVenda;
    }

    public void setIdItemVenda(int idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    public int getIdVenda() {
        return this.idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdProduto() {
        return this.idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQtd() {
        return this.qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
        calcularSubtotal();
    }

    public float getPrecoUnidade() {
        return this.precoUnidade;
    }

    public void setPrecoUnidade(float precoUnidade) {
        this.precoUnidade = precoUnidade;
        calcularSubtotal();
    }

    public float getSubtotal() {
        return this.subtotal;
    }

    public void calcularSubtotal() {
        this.subtotal = this.qtd * this.precoUnidade;
    }
}