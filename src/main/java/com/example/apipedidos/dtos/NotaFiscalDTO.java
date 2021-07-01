package com.example.apipedidos.dtos;

import com.example.apipedidos.models.Prato;

import java.util.List;

public class NotaFiscalDTO {

    private List<Prato> pratos;
    private double totalItens;

    public NotaFiscalDTO(List<Prato> pratos, double totalItens) {
        this.pratos = pratos;
        this.totalItens = totalItens;
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public double getTotalItens() {
        return totalItens;
    }
}
