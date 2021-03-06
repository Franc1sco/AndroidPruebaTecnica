package com.example.pruebatecnica.model;

import java.util.Comparator;

public class Client {
    private final int codigo;
    private final String nombre;
    private final String telefono;
    private final String email;
    private final String visitado;

    public Client(int codigo, String nombre, String telefono, String email, String visitado) {
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

    public static class OrderByCode implements Comparator<Client>
    {
        public int compare(Client left, Client right) {
            return left.getCodigo() - right.getCodigo();
        }
    }

    public static class OrderByName implements Comparator<Client>
    {
        public int compare(Client left, Client right) {
            return left.getNombre().compareTo(right.getNombre());
        }
    }
}
