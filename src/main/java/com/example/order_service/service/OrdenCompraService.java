package com.example.order_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.order_service.model.OrdenCompra;
import com.example.order_service.repository.OrdenCompraRepository;

@Service
public class OrdenCompraService {

    @Autowired
    private OrdenCompraRepository ordenRepository;

    public OrdenCompra crearOrden(OrdenCompra orden) {

        // Evitar NullPointerException si la lista es null
        if (orden.getProductos() != null) {
            orden.getProductos().forEach(p -> p.setOrden(orden));
        }

        return ordenRepository.save(orden);
    }

    public List<OrdenCompra> listar() {
        return ordenRepository.findAll();
    }

    public Optional<OrdenCompra> buscarPorId(Long id) {
        return ordenRepository.findById(id);
    }

}
