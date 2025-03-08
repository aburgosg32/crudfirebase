package com.example.crudfirebase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ClientesAdpater extends RecyclerView.Adapter<ClientesAdpater.ViewHolderClientes> {

    List<Clientes> listaclientes;

    public ClientesAdpater(List<Clientes> clientes){
        this.listaclientes = clientes;
    }


    @NonNull
    @Override
    public ClientesAdpater.ViewHolderClientes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_recycler,parent,false);
        ViewHolderClientes holder = new ViewHolderClientes(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ClientesAdpater.ViewHolderClientes holder, int position) {

        Clientes cliente = listaclientes.get(position);

        holder.apellidos.setText(cliente.getApellido());
        holder.nombres.setText(cliente.getNombre());
        holder.telefono.setText(cliente.getTelefono());
        holder.correo.setText(cliente.getCorreo());

    }

    @Override
    public int getItemCount() {
        return listaclientes.size();
    }

    public class ViewHolderClientes extends RecyclerView.ViewHolder{

        TextView apellidos, nombres, telefono, correo;
        public ViewHolderClientes(@NonNull View itemView){
            super(itemView);
            apellidos = itemView.findViewById(R.id.txtApellidolista);
            nombres = itemView.findViewById(R.id.txtNombreLista);
            telefono = itemView.findViewById(R.id.txtTelefonoLista);
            correo = itemView.findViewById(R.id.txtCorreoLista);
        }
    }
}
