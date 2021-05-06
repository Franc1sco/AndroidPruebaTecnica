package com.example.pruebatecnica.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.pruebatecnica.model.Clients;
import com.example.pruebatecnica.databinding.ItemListBinding;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {

    ArrayList<Clients> listData;

    public AdapterDatos(ArrayList<Clients> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemListBinding itemListBinding = ItemListBinding.inflate(layoutInflater, parent, false);
        return new ViewHolderDatos(itemListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        Clients cliente = listData.get(position);
        holder.itemListBinding.setCliente(cliente);
        holder.itemListBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class ViewHolderDatos extends RecyclerView.ViewHolder {

        ItemListBinding itemListBinding;

        public ViewHolderDatos(@NonNull ItemListBinding itemListBinding) {
            super(itemListBinding.getRoot());
            this.itemListBinding = itemListBinding;
        }
    }
}
