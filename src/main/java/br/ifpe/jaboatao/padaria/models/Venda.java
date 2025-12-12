package br.ifpe.jaboatao.padaria.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venda {
    private int idVenda;
    private LocalDate data;
    private int idCliente;
    private int idFuncionario;
    private float valorTotal;

    public Venda() {
        this.data = LocalDate.now();
    }

    public Venda(int idVenda, LocalDate data, int idCliente, int idFuncionario, float valorTotal) {
        this.idVenda = idVenda;
        this.data = data;
        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
        this.valorTotal = valorTotal;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
}