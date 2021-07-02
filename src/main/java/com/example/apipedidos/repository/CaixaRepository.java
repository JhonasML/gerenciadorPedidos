package com.example.apipedidos.repository;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class CaixaRepository {

    private double valorEmCaixa = 0;

    public double getValorEmCaixa() {
        return valorEmCaixa;
    }

    public void setValorEmCaixa(double valorEmCaixa) {
        this.valorEmCaixa = valorEmCaixa;
    }
}
