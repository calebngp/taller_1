package com.talle.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "items_venta")
public class ItemVenta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String producto;
    
    @Column(nullable = false)
    private Integer cantidad;
    
    @Column(nullable = false)
    private Double precio;
    
    @Column(nullable = false)
    private Double subtotal;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venta_id", nullable = false)
    @JsonBackReference
    private Venta venta;
    
    // Constructores
    public ItemVenta() {}
    
    public ItemVenta(String producto, Integer cantidad, Double precio, Double subtotal) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getProducto() {
        return producto;
    }
    
    public void setProducto(String producto) {
        this.producto = producto;
    }
    
    public Integer getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    public Double getPrecio() {
        return precio;
    }
    
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    public Double getSubtotal() {
        return subtotal;
    }
    
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
    
    public Venta getVenta() {
        return venta;
    }
    
    public void setVenta(Venta venta) {
        this.venta = venta;
    }
}

