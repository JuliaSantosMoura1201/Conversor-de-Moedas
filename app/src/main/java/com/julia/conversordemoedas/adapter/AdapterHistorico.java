package com.julia.conversordemoedas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.julia.conversordemoedas.R;
import com.julia.conversordemoedas.model.Item;

import java.util.List;

public class AdapterHistorico extends RecyclerView.Adapter<AdapterHistorico.MyViewHolder> {

    private List<Item> lista;

    public AdapterHistorico(List<Item> list) {
        this.lista = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_historico, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item = lista.get(position);
        holder.moeda1.setText(item.getRate());
        holder.moeda2.setText(item.getRate2());
        holder.valor1.setText(item.getValDig());
        holder.valor2.setText(item.getValFinal());
    }

    @Override
    public int getItemCount() {
        return this.lista.size();
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
