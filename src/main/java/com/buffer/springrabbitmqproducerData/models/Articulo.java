package com.buffer.springrabbitmqproducerData.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Articulo {

    @Id
    private String id;
    @Field
    private String nombre;
    @Field
    private String unidad;
    @Field
    private String clave;
    @Field
    private Float precio;

    public Articulo(String id, String nombre, String unidad, String clave, Float precio) {
        this.id = id;
        this.nombre = nombre;
        this.unidad = unidad;
        this.clave = clave;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", unidad='" + unidad + '\'' +
                ", clave='" + clave + '\'' +
                ", precio=" + precio +
                '}';
    }

}
