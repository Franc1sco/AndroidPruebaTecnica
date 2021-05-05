package com.example.pruebatecnica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<Clientes> listDatos;
    ArrayList<Clientes> listDatosFull;
    RecyclerView recycler;
    AdapterDatos adapter;
    Spinner spinner;
    CheckBox checkbox;

    boolean orderByCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.recyclerView);
        spinner = findViewById(R.id.options_id);
        checkbox = findViewById(R.id.checkBoxVisitado);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler.setHasFixedSize(true);

        listDatos = new ArrayList<>();
        listDatosFull = new ArrayList<>();


        for(int i=1; i<200; i++)
        {
            Random random = new Random();

            listDatos.add(new Clientes(i, "pepe", "55555", "nose@nose", random.nextBoolean()?"Si":"No"));
        }

        for(int i=1; i<200; i++)
        {
            Random random = new Random();

            listDatos.add(new Clientes(i, "alex", "55555", "nose@nose", random.nextBoolean()?"Si":"No"));
        }

        for(int i=1; i<200; i++)
        {
            Random random = new Random();

            listDatos.add(new Clientes(i, "miguel", "55555", "nose@nose", random.nextBoolean()?"Si":"No"));
        }

        orderByCode = false;
        Collections.sort(listDatos, new OrdenarNombre());

        listDatosFull.addAll(listDatos);

        adapter = new AdapterDatos(listDatos);
        recycler.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch (position)
                {
                    case 0:{
                        Collections.sort(listDatos, new OrdenarNombre());
                        adapter.notifyDataSetChanged();
                        orderByCode = false;
                        break;
                    }
                    case 1:{
                        Collections.sort(listDatos, new OrdenarCodigo());
                        adapter.notifyDataSetChanged();
                        orderByCode = true;
                        break;
                    }
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });
    }

    public void onClickVisitado(View v) {

        listDatos.clear();

        if(checkbox.isChecked()){

            for(int i=0; i<listDatosFull.size(); i++)
            {
                if(listDatosFull.get(i).getVisitado().equals("No"))
                    listDatos.add(listDatosFull.get(i));
            }

        }else{
            listDatos.addAll(listDatosFull);
        }

        if(orderByCode)
            Collections.sort(listDatos, new OrdenarCodigo());

        adapter.notifyDataSetChanged();
    }
}