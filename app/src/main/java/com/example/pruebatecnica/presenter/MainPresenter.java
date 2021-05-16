package com.example.pruebatecnica.presenter;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.Spinner;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pruebatecnica.R;
import com.example.pruebatecnica.data.ClientDataSet;
import com.example.pruebatecnica.model.Client;
import com.example.pruebatecnica.view.MainActivity;
import com.example.pruebatecnica.view.adapter.ClientAdapter;

import java.util.ArrayList;
import java.util.Collections;

import static android.Manifest.permission.CALL_PHONE;

public class MainPresenter implements MainView {

    private final MainActivity view;
    private ArrayList<Client> listDataAdapter;
    private ArrayList<Client> listDataFullAdapter;
    private RecyclerView recycler;
    private ClientAdapter adapter;
    private Spinner spinner;
    private CheckBox checkbox;

    private static final int ITEM_NAME = 0;
    private static final int ITEM_CODE = 1;

    public MainPresenter(MainActivity view) {
        this.view = view;
    }

    @Override
    public void setupView() {
        recycler = view.findViewById(R.id.recyclerView);
        spinner = view.findViewById(R.id.options_id);
        checkbox = view.findViewById(R.id.checkBoxVisitado);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch (position)
                {
                    case ITEM_NAME:{
                        Collections.sort(listDataAdapter, new Client.OrderByName());
                        adapter.notifyDataSetChanged();
                        break;
                    }
                    case ITEM_CODE:{
                        Collections.sort(listDataAdapter, new Client.OrderByCode());
                        adapter.notifyDataSetChanged();
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });

        checkbox.setOnClickListener(v -> {
            listDataAdapter.clear();

            if(checkbox.isChecked()){

                for(int i = 0; i< listDataFullAdapter.size(); i++)
                {
                    if(listDataFullAdapter.get(i).getVisitado().equals("No")) {
                        listDataAdapter.add(listDataFullAdapter.get(i));
                    }
                }

            }else{
                listDataAdapter.addAll(listDataFullAdapter);
            }

            if(spinner.getSelectedItemPosition() == ITEM_CODE){
                Collections.sort(listDataAdapter, new Client.OrderByCode());
            }

            adapter.notifyDataSetChanged();
        });
    }

    @Override
    public void setupAdapter() {
        recycler.setLayoutManager(new LinearLayoutManager(view,
                LinearLayoutManager.VERTICAL, false));
        recycler.setHasFixedSize(true);

        listDataAdapter = new ArrayList<>();
        listDataFullAdapter = new ArrayList<>();

        ClientDataSet clientDataSet = new ClientDataSet();
        listDataAdapter.addAll(clientDataSet.generateClientList());

        Collections.sort(listDataAdapter, new Client.OrderByName());

        listDataFullAdapter.addAll(listDataAdapter);

        adapter = new ClientAdapter(listDataAdapter);
        recycler.setAdapter(adapter);
    }

    @Override
    public void showCall(String number) {

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" +number ));

        if (ContextCompat.checkSelfPermission(view, CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            view.startActivity(callIntent);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            view.requestPermissions(new String[]{CALL_PHONE}, 1);
        }
    }
}
