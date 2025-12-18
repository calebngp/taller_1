package com.talle.backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ventas")
public class Venta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String cliente;
    
    @Column(nullable = false)
    private String metodoPago;
    
    @Column(length = 1000)
    private String descripcion;
    
    @Column(nullable = false)
    private Double total;
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;
    
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<ItemVenta> items = new ArrayList<>();
    
    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
    }
    
    // Constructores
    public Venta() {}
    
    public Venta(String cliente, String metodoPago, String descripcion, Double total) {
        this.cliente = cliente;
        this.metodoPago = metodoPago;
        this.descripcion = descripcion;
        this.total = total;
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCliente() {
        return cliente;
    }
    
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    public String getMetodoPago() {
        return metodoPago;
    }
    
    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Double getTotal() {
        return total;
    }
    
    public void setTotal(Double total) {
        this.total = total;
    }
    
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    public List<ItemVenta> getItems() {
        return items;
    }
    
    public void setItems(List<ItemVenta> items) {
        this.items = items;
    }
    
    public void addItem(ItemVenta item) {
        items.add(item);
        item.setVenta(this);
    }
}

