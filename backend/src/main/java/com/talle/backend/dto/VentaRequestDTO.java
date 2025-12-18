package com.talle.backend.dto;

import java.util.List;

public class VentaRequestDTO {
    private String cliente;
    private String metodoPago;
    private String descripcion;
    private List<ItemVentaDTO> items;
    
    // Constructores
    public VentaRequestDTO() {}
    
    // Getters y Setters
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
    
    public List<ItemVentaDTO> getItems() {
        return items;
    }
    
    public void setItems(List<ItemVentaDTO> items) {
        this.items = items;
    }
    
    public static class ItemVentaDTO {
        private String producto;
        private Integer cantidad;
        private Double precio;
        private Double subtotal;
        
        // Constructores
        public ItemVentaDTO() {}
        
        // Getters y Setters
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
    }
}

