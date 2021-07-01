package com.example.apipedidos.models;

import java.util.ArrayList;
import java.util.List;

public class Mesa {

    private int id;
    private List<Pedido> pedidos;
    private double valorTotalConsumido;

    public Mesa(List<Pedido> pedidos, double totalConsumido) {
        this.pedidos = pedidos;
        this.valorTotalConsumido = totalConsumido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public double getValorTotalConsumido() {
        return valorTotalConsumido;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void setValorTotalConsumido(double valorTotalConsumido) {
        this.valorTotalConsumido = valorTotalConsumido;
    }

    public void limparMesa() {
        this.pedidos = new ArrayList<Pedido>();
        this.valorTotalConsumido = 0;
    }
}
