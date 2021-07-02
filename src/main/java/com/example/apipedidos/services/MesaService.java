package com.example.apipedidos.services;

import com.example.apipedidos.repository.CaixaRepository;
import com.example.apipedidos.dao.MesaDao;
import com.example.apipedidos.dtos.CaixaDTO;
import com.example.apipedidos.dtos.NotaFiscalDTO;
import com.example.apipedidos.exceptions.NotFoundException;
import com.example.apipedidos.models.Mesa;
import com.example.apipedidos.models.Pedido;
import com.example.apipedidos.models.Prato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MesaService {

    private MesaDao mesaDao;
    private CaixaRepository caixaRepository;

    @Autowired
    public MesaService(MesaDao mesaDao, CaixaRepository caixaRepository) {
        this.mesaDao = mesaDao;
        this.caixaRepository = caixaRepository;
    }

    public Mesa criaMesa(Mesa mesa) {
        try {
            mesa = mesaDao.persisteMesa(mesa);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mesa;
    }

    public NotaFiscalDTO pedidosPorMesa(int id) {
        Mesa mesa = mesaDao.getMesaById(id);
        validaMesa(mesa);

        List<Prato> pratos = new ArrayList();

        for (Pedido pedido : mesa.getPedidos()) {
            pratos.addAll(pedido.getPratos());
        }

        return new NotaFiscalDTO(pratos, mesa.getValorTotalConsumido());
    }

    public void fecharMesa(int mesaId) {
        Mesa mesa = mesaDao.getMesaById(mesaId);
        validaMesa(mesa);

        caixaRepository.setValorEmCaixa(caixaRepository.getValorEmCaixa() + mesa.getValorTotalConsumido());
        mesa.limparMesa();
//        mesasRepository.atualizaMesa(mesaId, mesa);
    }

    public CaixaDTO retornaValorCaixa() {
        return new CaixaDTO(caixaRepository.getValorEmCaixa());
    }

    private void validaMesa(Mesa mesa) {
        if (Objects.isNull(mesa)) {
            throw new NotFoundException("Mesa não encontrada");
        }
    }
}
