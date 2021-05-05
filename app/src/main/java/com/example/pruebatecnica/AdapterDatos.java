package com.example.pruebatecnica;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static java.lang.String.*;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {

    ArrayList<Clientes> listDatos;
    ArrayList<Clientes> listDatosFull;

    public AdapterDatos(ArrayList<Clientes> listDatos) {
        this.listDatos = listDatos;
        this.listDatosFull = new ArrayList<>(listDatos);
    }

    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, null, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.asignarDatos(listDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public static class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView codigo;
        TextView nombre;
        TextView telefono;
        TextView email;
        TextView visitado;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            codigo=itemView.findViewById(R.id.codigo);
            nombre=itemView.findViewById(R.id.nombre);
            telefono=itemView.findViewById(R.id.telefono);
            email=itemView.findViewById(R.id.email);
            visitado=itemView.findViewById(R.id.visitado);
        }

        public void asignarDatos(Clientes clientes) {
            codigo.setText(format("%d", clientes.getCodigo()));
            nombre.setText(clientes.getNombre());
            telefono.setText(clientes.getTelefono());
            email.setText(clientes.getEmail());
            visitado.setText(clientes.getVisitado());
        }
    }
}
