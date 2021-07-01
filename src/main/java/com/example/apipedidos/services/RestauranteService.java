package com.example.apipedidos.services;

import com.example.apipedidos.daos.CaixaDAO;
import com.example.apipedidos.daos.MesasDAO;
import com.example.apipedidos.dtos.CaixaDTO;
import com.example.apipedidos.dtos.NotaFiscalDTO;
import com.example.apipedidos.exceptions.NotFoundException;
import com.example.apipedidos.models.Mesa;
import com.example.apipedidos.models.Pedido;
import com.example.apipedidos.models.Prato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RestauranteService {

    private MesasDAO mesasDAO;
    private CaixaDAO caixaDAO;

    @Autowired
    public RestauranteService(MesasDAO mesasDAO, CaixaDAO caixaDAO) {
        this.mesasDAO = mesasDAO;
        this.caixaDAO = caixaDAO;
    }

    public NotaFiscalDTO pedidosPorMesa (int id) {
        Mesa mesa = mesasDAO.getMesaById(id);
        validaMesa(mesa);

        List<Prato> pratos = new ArrayList();

        for (Pedido pedido : mesa.getPedidos()) {
            pratos.addAll(pedido.getPratos());
        }

        return new NotaFiscalDTO(pratos, mesa.getValorTotalConsumido());
    }

    public void fecharMesa (int mesaId) {
        Mesa mesa = mesasDAO.getMesaById(mesaId);
        validaMesa(mesa);

        caixaDAO.setValorEmCaixa(caixaDAO.getValorEmCaixa() + mesa.getValorTotalConsumido());
        mesa.limparMesa();
        mesasDAO.atualizaMesa(mesaId, mesa);
    }

    public CaixaDTO retornaValorCaixa() {
        return new CaixaDTO(caixaDAO.getValorEmCaixa());
    }

    private void validaMesa(Mesa mesa) {
        if(Objects.isNull(mesa)) {
            throw new NotFoundException("Mesa não encontrada");
        }
    }
}
