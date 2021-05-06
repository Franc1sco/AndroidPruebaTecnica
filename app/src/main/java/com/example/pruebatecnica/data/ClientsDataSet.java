package com.example.pruebatecnica.data;

import com.example.pruebatecnica.model.Clients;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClientsDataSet {
    public List<Clients> generateClientList()
    {
        ArrayList<Clients> list = new ArrayList<>();

        for(int i=1; i<200; i++)
        {
            Random random = new Random();

            list.add(new Clients(i, "pepe", "55555", "nose@nose", random.nextBoolean()?"Si":"No"));
        }

        for(int i=1; i<200; i++)
        {
            Random random = new Random();

            list.add(new Clients(i, "alex", "55555", "nose@nose", random.nextBoolean()?"Si":"No"));
        }

        for(int i=1; i<200; i++)
        {
            Random random = new Random();

            list.add(new Clients(i, "miguel", "55555", "nose@nose", random.nextBoolean()?"Si":"No"));
        }

        return list;
    }
}
