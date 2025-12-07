package com.proyecto.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int usuarioId;
    private String nombreCompleto;
    private LocalDate fechaNacimiento;
    private String rut;
    private String direccion;
    private List<Retiro> retiros;

    public Usuario(int usuarioId, String nombreCompleto, LocalDate fechaNacimiento, 
                   String rut, String direccion) {
        this.usuarioId = usuarioId;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.rut = rut;
        this.direccion = direccion;
        this.retiros = new ArrayList<>();
    }

    public Retiro solicitudRetiro(String tipoMaterial, float kgMaterial) {
        Retiro retiro = new Retiro(tipoMaterial, kgMaterial, this);
        this.retiros.add(retiro);
        return retiro;
    }

    // Getters y Setters
    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public List<Retiro> getRetiros() { return retiros; }
    public void setRetiros(List<Retiro> retiros) { this.retiros = retiros; }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuarioId=" + usuarioId +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", rut='" + rut + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}