package com.julia.conversordemoedas.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.julia.conversordemoedas.R;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void abrirPrincipal(View view){
        Intent intent = new Intent(getApplicationContext(), ConversaoActivity.class);
        startActivity(intent);
        finish();
    }
}
