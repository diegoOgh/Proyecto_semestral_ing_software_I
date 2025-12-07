package com.proyecto.model;

import java.util.ArrayList;
import java.util.List;

public class Ruta {
    private int idRuta;
    private String ubicacion;
    private List<Paradaruta> paradarutas;
    private Trabajador trabajador;
    private CoordinadorRuta coordinador;

    public Ruta(int idRuta, String ubicacion) {
        this.idRuta = idRuta;
        this.ubicacion = ubicacion;
        this.paradarutas = new ArrayList<>();
    }

    public void agregarParadaruta(Paradaruta paradaruta) {
        if (!this.paradarutas.contains(paradaruta)) {
            this.paradarutas.add(paradaruta);
            paradaruta.setRuta(this);
        }
    }

    // Getters y Setters
    public int getIdRuta() { return idRuta; }
    public void setIdRuta(int idRuta) { this.idRuta = idRuta; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public List<Paradaruta> getParadarutas() { return paradarutas; }
    public void setParadarutas(List<Paradaruta> paradarutas) { this.paradarutas = paradarutas; }

    public Trabajador getTrabajador() { return trabajador; }
    public void setTrabajador(Trabajador trabajador) { this.trabajador = trabajador; }

    public CoordinadorRuta getCoordinador() { return coordinador; }
    public void setCoordinador(CoordinadorRuta coordinador) { this.coordinador = coordinador; }

    @Override
    public String toString() {
        return "Ruta{" +
                "idRuta=" + idRuta +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}