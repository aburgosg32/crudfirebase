package com.example.crudfirebase;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ClientesAdpater extends RecyclerView.Adapter<ClientesAdpater.ViewHolderClientes> {
    @NonNull
    @Override
    public ClientesAdpater.ViewHolderClientes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ClientesAdpater.ViewHolderClientes holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderClientes extends RecyclerView.ViewHolder{
        public ViewHolderClientes(@NonNull View itemView){
            super(itemView);
        }
    }
}
