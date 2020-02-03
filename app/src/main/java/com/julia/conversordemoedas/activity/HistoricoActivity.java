package com.julia.conversordemoedas.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.julia.conversordemoedas.R;
import com.julia.conversordemoedas.adapter.AdapterHistorico;
import com.julia.conversordemoedas.helper.ConversaoDAO;
import com.julia.conversordemoedas.helper.DBHelper;
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
        Log.i("CriarItens", "Existo");
        ConversaoDAO conversaoDAO = new ConversaoDAO(getApplicationContext());
        listaItens = conversaoDAO.listar();

        if (listaItens.isEmpty()){
            Log.i("CriarItens", "vazia");
        }
    }


}
