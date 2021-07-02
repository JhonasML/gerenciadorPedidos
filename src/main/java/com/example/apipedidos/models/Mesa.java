package com.example.apipedidos.models;

import java.util.ArrayList;
import java.util.List;

public class Mesa {

    private Integer id;
    private List<Pedido> pedidos;
    private double valorTotalConsumido;

    public Mesa(List<Pedido> pedidos, double totalConsumido) {
        this.pedidos = pedidos;
        this.valorTotalConsumido = totalConsumido;
    }

    public Integer getId() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mesa)) return false;

        Mesa mesa = (Mesa) o;

        return getId().equals(mesa.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
