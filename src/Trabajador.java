package com.proyecto.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Trabajador {
    protected int idTrabajador;
    protected String nombreCompleto;
    protected LocalDate fechaNacimiento;
    protected String rut;

    public Trabajador(int idTrabajador, String nombreCompleto, LocalDate fechaNacimiento, String rut) {
        this.idTrabajador = idTrabajador;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.rut = rut;
    }

    public List<Ruta> solicitudRuta(int idTrabajador) {
        if (this.idTrabajador == idTrabajador) {
            return obtenerRutasAsociadas();
        } else {
            System.out.println("Acceso denegado: Solo puedes ver tus propias rutas");
            return new ArrayList<>();
        }
    }

    protected abstract List<Ruta> obtenerRutasAsociadas();

    // Getters y Setters
    public int getIdTrabajador() { return idTrabajador; }
    public void setIdTrabajador(int idTrabajador) { this.idTrabajador = idTrabajador; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }

    @Override
    public String toString() {
        return "Trabajador{" +
                "idTrabajador=" + idTrabajador +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", rut='" + rut + '\'' +
                '}';
    }
}