package com.example.pruebatecnica;

import java.util.Comparator;

public class OrdenarNombre implements Comparator<Clientes>
{
    public int compare(Clientes left, Clientes right) {
        return left.getNombre().compareTo(right.getNombre());
    }
}
