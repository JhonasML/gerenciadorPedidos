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

import java.util.List;

public class Pedido {

    private int id;
    private int mesa;
    private List<Prato> pratos;

    public Pedido(int id, int mesa, List<Prato> pratos) {
        this.id = id;
        this.mesa = mesa;
        this.pratos = pratos;
    }

    public int getId() {
        return id;
    }

    public int getMesa() {
        return mesa;
    }

    public List<Prato> getPratos() {
        return pratos;
    }
}
