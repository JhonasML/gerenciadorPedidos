package com.example.apipedidos.dtos;

public class CaixaDTO {

    public double totalCaixa;

    public CaixaDTO(double valorEmCaixa) {
        this.totalCaixa = valorEmCaixa;
    }

    public double getTotalCaixa() {
        return totalCaixa;
    }

    public void setTotalCaixa(double totalCaixa) {
        this.totalCaixa = totalCaixa;
    }
}
