package com.julia.conversordemoedas.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.julia.conversordemoedas.R;
import com.julia.conversordemoedas.adapter.AdapterHistorico;
import com.julia.conversordemoedas.helper.ConversaoDAO;
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

        this.preencheLista();
        this.configRecyclerView();

    }

    public void preencheLista(){
        ConversaoDAO conversaoDAO = new ConversaoDAO(getApplicationContext());
        listaItens = conversaoDAO.listar();
    }

    public void configRecyclerView(){

        AdapterHistorico adapterHistorico = new AdapterHistorico(listaItens);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterHistorico);
    }

    public void abrirConversao(View view){
        Intent intent = new Intent(getApplicationContext(), ConversaoActivity.class);
        startActivity(intent);
    }


}
