package com.example.apipedidos.controllers;

import com.example.apipedidos.dtos.CaixaDTO;
import com.example.apipedidos.dtos.NotaFiscalDTO;
import com.example.apipedidos.exceptions.NotFoundException;
import com.example.apipedidos.models.Mesa;
import com.example.apipedidos.services.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/mesas")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @PostMapping
    public ResponseEntity<Mesa> criaMesa(@RequestBody Mesa mesa, UriComponentsBuilder uriComponentsBuilder){
        mesa = mesaService.criaMesa(mesa);
        UriComponents uriComponents = uriComponentsBuilder.path("/mesas/{id}").buildAndExpand(mesa.getId());
       return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @GetMapping(path = "/{id}/pedidos")
    public ResponseEntity<NotaFiscalDTO> consultarPedidos(@PathVariable int id) {

        try {
            NotaFiscalDTO notaFiscalDTO = mesaService.pedidosPorMesa(id);
            return new ResponseEntity<>(notaFiscalDTO, HttpStatus.OK);
        } catch(NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/fecha")
    public void fecharPedido(@PathVariable int id) {
        mesaService.fecharMesa(id);
    }

    @GetMapping("/caixa/valor")
    public ResponseEntity<CaixaDTO> valorCaixa() {
        CaixaDTO dto = mesaService.retornaValorCaixa();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
