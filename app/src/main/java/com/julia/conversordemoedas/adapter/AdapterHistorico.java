package com.julia.conversordemoedas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.julia.conversordemoedas.R;

public class AdapterHistorico extends RecyclerView.Adapter<AdapterHistorico.MyViewHolder> {

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_historico, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.moeda1.setText("Real");
        holder.moeda2.setText("Dolar");
        holder.valor1.setText("R$ 100,00");
        holder.valor2.setText("R$ 400, 00");
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView moeda1, moeda2, valor1, valor2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            moeda1 = itemView.findViewById(R.id.textMoeda1);
            moeda2 = itemView.findViewById(R.id.textMoeda2);
            valor1 = itemView.findViewById(R.id.textValor1);
            valor2 = itemView.findViewById(R.id.textValor2);
        }
    }
}
