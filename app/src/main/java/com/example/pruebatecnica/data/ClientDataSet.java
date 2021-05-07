package com.example.pruebatecnica.data;

import com.example.pruebatecnica.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClientDataSet {

    public List<Client> generateClientList()
    {
        ArrayList<Client> list = new ArrayList<>();

        for(int i=1; i<200; i++)
        {
            Random random = new Random();

            list.add(new Client(i, "pepe", "55555", "test@test.es", random.nextBoolean()?"Si":"No"));
        }

        for(int i=1; i<200; i++)
        {
            Random random = new Random();

            list.add(new Client(i, "alex", "55555", "test@test.es", random.nextBoolean()?"Si":"No"));
        }

        for(int i=1; i<200; i++)
        {
            Random random = new Random();

            list.add(new Client(i, "miguel", "55555", "test@test.es", random.nextBoolean()?"Si":"No"));
        }

        return list;
    }
}
