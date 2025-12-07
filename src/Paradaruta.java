package com.proyecto.model;

public class Paradaruta {
    private static int contadorId = 1;
    private int id;
    private int orden;
    private Retiro retiro;
    private Ruta ruta;

    public Paradaruta(int orden) {
        this.id = contadorId++;
        this.orden = orden;
    }

    // Getters y Setters
    public int getId() { return id; }

    public int getOrden() { return orden; }
    public void setOrden(int orden) { this.orden = orden; }

    public Retiro getRetiro() { return retiro; }
    public void setRetiro(Retiro retiro) { this.retiro = retiro; }

    public Ruta getRuta() { return ruta; }
    public void setRuta(Ruta ruta) { this.ruta = ruta; }

    @Override
    public String toString() {
        return "Paradaruta{" +
                "id=" + id +
                ", orden=" + orden +
                '}';
    }
}