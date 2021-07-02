package com.example.apipedidos.controllers;

import com.example.apipedidos.models.Pedido;
import com.example.apipedidos.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    private PedidoService pedidoService;

    @Autowired
    public PedidosController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<Pedido> criaPedido(@RequestBody Pedido pedido, UriComponentsBuilder uriComponentsBuilder) throws IOException {
        pedido = pedidoService.criaPedido(pedido);
        UriComponents uriComponents = uriComponentsBuilder.path("/pedidos/{id}").buildAndExpand(pedido.getId());
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @GetMapping("/{id}")
    public Pedido getPedido(@PathVariable Integer id){
        return pedidoService.obterPedido(id);
    }
}
