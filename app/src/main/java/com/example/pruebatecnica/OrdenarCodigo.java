package com.example.pruebatecnica;

import java.util.Comparator;

public class OrdenarCodigo implements Comparator<Clientes>
{
    public int compare(Clientes left, Clientes right) {
        return left.getCodigo().compareTo(right.getCodigo());
    }
}
