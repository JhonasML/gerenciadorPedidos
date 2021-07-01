package com.example.apipedidos.daos;

import org.springframework.stereotype.Service;

@Service
public class CaixaDAO {

    private double valorEmCaixa = 0;

    public double getValorEmCaixa() {
        return valorEmCaixa;
    }

    public void setValorEmCaixa(double valorEmCaixa) {
        this.valorEmCaixa = valorEmCaixa;
    }
}
