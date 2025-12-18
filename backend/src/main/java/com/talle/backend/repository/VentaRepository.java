package com.talle.backend.repository;

import com.talle.backend.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
    
    List<Venta> findByClienteContainingIgnoreCase(String cliente);
    
    List<Venta> findByFechaCreacionBetween(LocalDateTime inicio, LocalDateTime fin);
    
    List<Venta> findByMetodoPago(String metodoPago);
}

