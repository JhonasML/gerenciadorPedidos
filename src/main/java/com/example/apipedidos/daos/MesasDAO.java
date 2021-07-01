package com.example.apipedidos.daos;

import com.example.apipedidos.models.Mesa;
import com.example.apipedidos.models.Pedido;
import com.example.apipedidos.models.Prato;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MesasDAO {

    private static Map<Integer, Mesa> mesas = new HashMap();
    private static Integer id = 0;

    public MesasDAO() {
        this.preencherMesa();
        System.out.println("preencheu mesas!");
    }

    public Mesa getMesaById(int id) {
        return mesas.get(id);
    }

    public Mesa persisteMesa(Mesa mesa) {
        mesa.setId(id++);
        mesas.put(mesa.getId(), mesa);
        return mesa;
    }

    public Mesa atualizaMesa(int id, Mesa mesa) {
        mesas.put(id, mesa);
        return mesas.get(id);
    }

    public void preencherMesa() {
        List<Prato> pratos = Arrays.asList(
                new Prato(1, 10.0, "Prato Teste", 1),
                new Prato(2, 20.0, "Prato Teste 2", 1),
                new Prato(3, 30.0, "Prato Teste 3", 1),
                new Prato(4, 40.0, "Prato Teste 4", 1)
        );

        List<Pedido> pedidos = Arrays.asList(
                new Pedido(1, 1, pratos),
                new Pedido(2, 1, pratos),
                new Pedido(3, 3, pratos)
        );

        Mesa mesa = new Mesa(pedidos, 200.0);
        persisteMesa(mesa);
    }
}
