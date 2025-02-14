package com.example.apipedidos.models;

//Para este exercício você vai precisar criar um novo projeto Spring Boot.
//        1. Crie uma API para controle de pedidos em um restaurante.
//        2. Um Pedido deve ter id, mesa, lista de pratos solicitados e valor total.
//        3. Um Prato deve ter id, preço, descrição, quantidade.
//        4. Uma Mesa deve ter id, lista de pedidos e valor total consumido;
//        5. Você deve conseguir fazer uma consulta de pedidos por mesa retornando todos os
//        itens pedidos por esta além do valor total consumido.
//        6. Crie também um endpoint para fechamento de pedidos adicionando o valor total no
//        registro de caixa e retirando todos os pedidos para a respectiva mesa.
//        7. Você deve ser capaz de consultar o valor em caixa
//        Utilize as estruturas aprendidas até aqui para realizar a tarefa proposta.

import java.util.Date;
import java.util.List;

public class Pedido {
    private int id;
    private int mesa;
    private List<Prato> pratos;
    private boolean ativo;
    private Date data;

    public Pedido(int id) {
        this.id = id;
    }

    public Pedido(int id, int mesa, List<Prato> pratos) {
        this.id = id;
        this.mesa = mesa;
        this.pratos = pratos;
    }

    public Integer getId() {
        return id;
    }

    public int getMesa() {
        return mesa;
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido)) return false;

        Pedido pedido = (Pedido) o;

        return getId().equals(pedido.getId());
    }

    @Override
    public int hashCode() {
        return getId();
    }
}
