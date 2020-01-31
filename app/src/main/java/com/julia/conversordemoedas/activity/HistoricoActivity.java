package com.julia.conversordemoedas.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.julia.conversordemoedas.R;
import com.julia.conversordemoedas.adapter.AdapterHistorico;
import com.julia.conversordemoedas.model.Item;

import java.util.ArrayList;
import java.util.List;

public class HistoricoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Item> listaItens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        recyclerView = findViewById(R.id.recyclerView);

        this.criarItens();
        AdapterHistorico adapterHistorico = new AdapterHistorico(listaItens);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterHistorico);

    }

    public void criarItens(){
        Item item = new Item("cad", "hkd", "5.7", "36");
        this.listaItens.add(item);

        item = new Item("idk", "php", "5.7", "36");
        this.listaItens.add(item);

        item = new Item("dkk", "huf", "5.7", "36");
        this.listaItens.add(item);

        item = new Item("czk", "aud", "5.7", "36");
        this.listaItens.add(item);

        item = new Item("ron", "sek", "5.7", "36");
        this.listaItens.add(item);

        item = new Item("idr", "inr", "5.7", "36");
        this.listaItens.add(item);

        item = new Item("inr", "php", "5.7", "36");
        this.listaItens.add(item);

        item = new Item("idk", "ron", "5.7", "36");
        this.listaItens.add(item);
    }


}
