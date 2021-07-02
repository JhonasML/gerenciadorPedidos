package com.example.apipedidos.dao;

import com.example.apipedidos.models.Mesa;
import com.example.apipedidos.models.Pedido;
import com.example.apipedidos.models.Prato;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.*;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class MesaDao {

    private final String filePath = "src/main/resources/mesas.json";
    private final File file = new File(filePath);
    private final Random random = new Random();
    private final ObjectMapper mapper;

    @Autowired
    public MesaDao(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<Mesa> findMesas() {
        List<Mesa> mesas = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(file);
            TypeReference<List<Mesa>> typeReference = new TypeReference<>() {
            };

            mesas = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mesas;
    }


    public Mesa getMesaById(Integer id) {
        Optional<Mesa> optionalMesa = findMesas().stream().filter(m -> m.getId().equals(id)).findFirst();

        return optionalMesa.orElse(null);
    }

    public Mesa persisteMesa(Mesa mesa) throws IOException {
        mesa.setId(random.nextInt());

        var mesas = findMesas();
        mesas.add(mesa);

        bulkPersist(mesas);

        return mesa;
    }

    private void bulkPersist(List<Mesa> mesas) throws IOException {
        byte[] mesasBytes = mapper.writeValueAsBytes(mesas);

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(mesasBytes);
    }

    public Mesa atualizaMesa(int id, Mesa mesa) throws IOException {
        List<Mesa> mesas = findMesas();
        mesa.setId(id);

        mesas.remove(mesa);
        mesas.add(mesa);

        bulkPersist(mesas);
        return mesa;
    }

//    public void preencherMesa() {
//        List<Prato> pratos = Arrays.asList(
//                new Prato(1, 10.0, "Prato Teste", 1),
//                new Prato(2, 20.0, "Prato Teste 2", 1),
//                new Prato(3, 30.0, "Prato Teste 3", 1),
//                new Prato(4, 40.0, "Prato Teste 4", 1)
//        );
//
//        List<Pedido> pedidos = Arrays.asList(
//                new Pedido(1, 1, pratos),
//                new Pedido(2, 1, pratos),
//                new Pedido(3, 3, pratos)
//        );
//
//        Mesa mesa = new Mesa(pedidos, 200.0);
//        persisteMesa(mesa);
//    }
}
