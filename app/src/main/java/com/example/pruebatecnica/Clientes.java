package com.example.pruebatecnica;

public class Clientes {
    private int codigo;
    private String nombre;
    private String telefono;
    private String email;
    private String visitado;

    public Clientes(int codigo, String nombre, String telefono, String email, String visitado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.visitado = visitado;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getVisitado() {
        return visitado;
    }
}
