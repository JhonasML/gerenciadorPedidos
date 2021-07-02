package com.example.apipedidos.services;

import com.example.apipedidos.models.Pedido;
import com.example.apipedidos.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PedidoService {

    private PedidosRepository pedidosRepository;

    @Autowired
    public PedidoService(PedidosRepository pedidosRepository) {
        this.pedidosRepository = pedidosRepository;
    }

    public Pedido criaPedido(Pedido pedido) throws IOException {
        return pedidosRepository.create(pedido);
    }

    public Pedido obterPedido(Integer id) {
        return pedidosRepository.findById(id);
    }
}
