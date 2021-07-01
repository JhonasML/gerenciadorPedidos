package com.example.apipedidos.controllers;

import com.example.apipedidos.daos.CaixaDAO;
import com.example.apipedidos.dtos.CaixaDTO;
import com.example.apipedidos.dtos.NotaFiscalDTO;
import com.example.apipedidos.exceptions.NotFoundException;
import com.example.apipedidos.services.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/restaurante")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping(path = "/mesas/{id}/pedidos")
    public ResponseEntity<NotaFiscalDTO> consultarPedidos(@PathVariable int id) {

        try {
            NotaFiscalDTO notaFiscalDTO = restauranteService.pedidosPorMesa(id);
            return new ResponseEntity<>(notaFiscalDTO, HttpStatus.OK);
        } catch(NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/mesas/{id}/fecha")
    @ResponseBody
    public void fecharPedido(@PathVariable int id) {
        restauranteService.fecharMesa(id);
    }

    @GetMapping("/caixa/valor")
    @ResponseBody
    public ResponseEntity<CaixaDTO> valorCaixa() {
        CaixaDTO dto = restauranteService.retornaValorCaixa();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
