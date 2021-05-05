package com.example.pruebatecnica;

public class Clientes {
    private String codigo;
    private String nombre;
    private String telefono;
    private String email;
    private String visitado;

    public Clientes(String codigo, String nombre, String telefono, String email, String visitado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.visitado = visitado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVisitado() {
        return visitado;
    }

    public void setVisitado(String visitado) {
        this.visitado = visitado;
    }
}
