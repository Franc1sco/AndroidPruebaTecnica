package com.example.pruebatecnica;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> implements Filterable {

    ArrayList<Clientes> listDatos;
    ArrayList<Clientes> listDatosFull;

    public AdapterDatos(ArrayList<Clientes> listDatos) {
        this.listDatos = listDatos;
        this.listDatosFull = listDatos;
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

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String filterString = constraint.toString();
            FilterResults results = new FilterResults();

            final ArrayList<Clientes> tempArray = new ArrayList<>();

            String filterableString;

            for (int i = 0; i < listDatosFull.size(); i++) {
                filterableString = listDatosFull.get(i).getVisitado();
                if (!filterableString.equals(filterString)) {
                    tempArray.add(listDatosFull.get(i));
                }
            }

            results.values = tempArray;
            results.count = tempArray.size();

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {
            listDatos.clear();
            listDatos = (ArrayList<Clientes>) results.values;
            notifyDataSetChanged();
        }
    };

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
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
            codigo.setText(clientes.getCodigo());
            nombre.setText(clientes.getNombre());
            telefono.setText(clientes.getTelefono());
            email.setText(clientes.getEmail());
            visitado.setText(clientes.getVisitado());
        }
    }
}
