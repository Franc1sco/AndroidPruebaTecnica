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
    RecyclerView recycler;
    AdapterDatos adapter;
    Spinner spinner;
    CheckBox checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler=findViewById(R.id.recyclerView);
        spinner = findViewById(R.id.options_id);
        checkbox=findViewById(R.id.checkBoxVisitado);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        listDatos = new ArrayList<>();


        for(int i=1; i<200; i++)
        {
            Random random = new Random();

            listDatos.add(new Clientes(""+i, "pepe", "55555", "nose@nose", random.nextBoolean()?"Si":"No"));
        }

        for(int i=1; i<200; i++)
        {
            Random random = new Random();

            listDatos.add(new Clientes(""+i, "alex", "55555", "nose@nose", random.nextBoolean()?"Si":"No"));
        }

        for(int i=1; i<200; i++)
        {
            Random random = new Random();

            listDatos.add(new Clientes(""+i, "miguel", "55555", "nose@nose", random.nextBoolean()?"Si":"No"));
        }

        Collections.sort(listDatos, new OrdenarNombre());

        adapter = new AdapterDatos(listDatos);
        recycler.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch (position)
                {
                    case 0:{

                        break;
                    }
                    case 1:{

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
        if(checkbox.isChecked()){
            adapter.getFilter().filter("Si");
        }else{
            adapter.getFilter().filter("");
        }
    }
}