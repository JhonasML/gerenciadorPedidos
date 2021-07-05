package com.example.apipedidos.repository;

import com.example.apipedidos.dao.MesaDao;
import com.example.apipedidos.models.Mesa;
import com.example.apipedidos.models.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Objects.isNull;

@Repository
public class PedidosRepository {

    private MesaDao mesaDao;
    private final Random random = new Random();

    @Autowired
    public PedidosRepository(MesaDao mesaDao) {
        this.mesaDao = mesaDao;
    }

    public Pedido create(Pedido pedido) throws IOException {
        Mesa mesa = mesaDao.getMesaById(pedido.getMesa());

        pedido.setId(random.nextInt());

        List<Pedido> pedidos = mesa.getPedidos();

        if (isNull(pedidos)) {
            pedidos = new ArrayList<>();
        }

        pedidos.add(pedido);
        mesa.setPedidos(pedidos);
        mesaDao.atualizaMesa(pedido.getMesa(), mesa);

        return pedido;
    }

    public Pedido findById(Integer id) {
        List<Mesa> mesas = mesaDao.findMesas();

        for (Mesa mesa : mesas) {
            for (Pedido pedido : mesa.getPedidos()) {
                if (pedido.getId().equals(id)) {
                    return pedido;
                }
            }
        }

        return null;
    }

    public List<Pedido> find() {
        List<Mesa> mesas = mesaDao.findMesas();

        List<Pedido> pedidos = new ArrayList<>();
        for (Mesa mesa : mesas) {
            pedidos.addAll(mesa.getPedidos());
        }

        return pedidos;
    }

    public Pedido update(Integer id, Pedido pedido) throws IOException {
        List<Mesa> mesas = mesaDao.findMesas();

        pedido.setId(id);
        for (Mesa mesa : mesas) {
            if (mesa.getPedidos().contains(pedido)) {
                mesa.getPedidos().remove(pedido);
                mesa.getPedidos().add(pedido);

                mesaDao.atualizaMesa(mesa.getId(), mesa);
            }
        }

        return pedido;
    }

    public void delete(Integer id) throws IOException {
        List<Mesa> mesas = mesaDao.findMesas();
        var pedido = new Pedido(id);

        for (Mesa mesa : mesas) {
            if (mesa.getPedidos().contains(pedido)) {
                mesa.getPedidos().remove(pedido);

                mesaDao.atualizaMesa(mesa.getId(), mesa);
            }
        }
    }

}
