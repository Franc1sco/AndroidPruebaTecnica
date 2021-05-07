package com.example.pruebatecnica.data;

import com.example.pruebatecnica.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClientDataSet {

    public List<Client> generateClientList()
    {
        ArrayList<Client> list = new ArrayList<>();

        Random random = new Random();

        for(int i=1; i<=200; i++)
        {
            list.add(new Client(i, "Pepe", "55555", "test@test.es", random.nextBoolean()?"Si":"No"));
        }

        for(int i=201; i<=400; i++)
        {
            list.add(new Client(i, "Alex", "66666", "test@test.es", random.nextBoolean()?"Si":"No"));
        }

        for(int i=401; i<=600; i++)
        {
            list.add(new Client(i, "Flor", "77777", "test@test.es", random.nextBoolean()?"Si":"No"));
        }

        return list;
    }
}
