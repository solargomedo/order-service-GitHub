package com.example.order_service.controller;

import com.example.order_service.model.OrdenCompra;
import com.example.order_service.service.OrdenCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraService servicio;

    @PostMapping
    public ResponseEntity<OrdenCompra> crear(@RequestBody OrdenCompra orden) {
        return ResponseEntity.ok(servicio.crearOrden(orden));
    }

    @GetMapping
    public ResponseEntity<List<OrdenCompra>> listar() {
        return ResponseEntity.ok(servicio.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenCompra> obtener(@PathVariable Long id) {
        return servicio.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
