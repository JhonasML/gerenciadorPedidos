package com.example.apipedidos.services;

import com.example.apipedidos.models.Pedido;
import com.example.apipedidos.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

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

    public Pedido obterPedidoPorId(Integer id) {
        return pedidosRepository.findById(id);
    }

    public List<Pedido> obterPedidos() {
        return pedidosRepository.find();
    }

    public Pedido alterar(Integer id, Pedido pedido) throws IOException {
        return pedidosRepository.update(id, pedido);
    }

    public void delete(Integer id) throws IOException {
        pedidosRepository.delete(id);
    }
}
