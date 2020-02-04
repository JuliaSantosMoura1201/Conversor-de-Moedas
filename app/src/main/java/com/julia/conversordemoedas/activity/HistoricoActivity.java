package com.julia.conversordemoedas.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.julia.conversordemoedas.R;
import com.julia.conversordemoedas.adapter.AdapterHistorico;
import com.julia.conversordemoedas.helper.ClickListener;
import com.julia.conversordemoedas.helper.ConversaoDAO;
import com.julia.conversordemoedas.model.Item;

import java.util.ArrayList;
import java.util.List;

public class HistoricoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Item> listaItens = new ArrayList<>();
    private List<Item> listaInversa = new ArrayList<>();
    private Item item;
    private AdapterHistorico adapterHistorico;
    private int flag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.addOnItemTouchListener(
                new ClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new ClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                item = listaItens.get(position);
                                AlertDialog.Builder dialog = new AlertDialog.Builder(HistoricoActivity.this);
                                dialog.setTitle("Confirmar exclusão?");
                                dialog.setMessage("Ao excluir essa conversão ela não poderá ser restaurada");
                                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        ConversaoDAO conversaoDAO = new ConversaoDAO(getApplicationContext());
                                        if (conversaoDAO.deletar(item)){
                                            preencheLista();
                                        }else{
                                            Toast.makeText(getApplicationContext(), "Erro ao excluir!", Toast.LENGTH_SHORT).show();
                                        }

                                    }
                                });
                                dialog.setNegativeButton("Não", null);
                                dialog.create();
                                dialog.show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
        this.preencheLista();

    }

    public void preencheLista(){
        ConversaoDAO conversaoDAO = new ConversaoDAO(getApplicationContext());

        listaItens = conversaoDAO.listar();
        adapterHistorico = new AdapterHistorico(listaItens);
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
