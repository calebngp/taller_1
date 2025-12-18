package com.talle.backend.controller;

import com.talle.backend.dto.VentaRequestDTO;
import com.talle.backend.model.ItemVenta;
import com.talle.backend.model.Venta;
import com.talle.backend.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin(origins = "http://localhost:4200")
public class VentaController {
    
    @Autowired
    private VentaRepository ventaRepository;
    
    @PostMapping
    public ResponseEntity<?> crearVenta(@RequestBody VentaRequestDTO request) {
        try {
            // Calcular el total
            double total = request.getItems().stream()
                .mapToDouble(VentaRequestDTO.ItemVentaDTO::getSubtotal)
                .sum();
            
            // Crear la venta
            Venta venta = new Venta(
                request.getCliente(),
                request.getMetodoPago(),
                request.getDescripcion(),
                total
            );
            
            // Agregar items
            for (VentaRequestDTO.ItemVentaDTO itemDTO : request.getItems()) {
                ItemVenta item = new ItemVenta(
                    itemDTO.getProducto(),
                    itemDTO.getCantidad(),
                    itemDTO.getPrecio(),
                    itemDTO.getSubtotal()
                );
                venta.addItem(item);
            }
            
            // Guardar la venta
            Venta ventaGuardada = ventaRepository.save(venta);
            
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Venta creada exitosamente");
            response.put("venta", ventaGuardada);
            response.put("id", ventaGuardada.getId());
            
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Error al crear la venta: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Venta>> obtenerTodasLasVentas() {
        List<Venta> ventas = ventaRepository.findAll();
        return ResponseEntity.ok(ventas);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerVentaPorId(@PathVariable Long id) {
        return ventaRepository.findById(id)
            .map(venta -> ResponseEntity.ok(venta))
            .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/cliente/{cliente}")
    public ResponseEntity<List<Venta>> obtenerVentasPorCliente(@PathVariable String cliente) {
        List<Venta> ventas = ventaRepository.findByClienteContainingIgnoreCase(cliente);
        return ResponseEntity.ok(ventas);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarVenta(@PathVariable Long id) {
        if (ventaRepository.existsById(id)) {
            ventaRepository.deleteById(id);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Venta eliminada exitosamente");
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }
}

