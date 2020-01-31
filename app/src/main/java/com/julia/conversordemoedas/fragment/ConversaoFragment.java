package com.julia.conversordemoedas.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.julia.conversordemoedas.ModeloService;
import com.julia.conversordemoedas.R;
import com.julia.conversordemoedas.model.Modelo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConversaoFragment extends Fragment {

    private ModeloService modeloService;
    private TextView resultado;
    private String resultadoSpinner1, resultadoSpinner2;

    public ConversaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_conversao, container, false);

        resultado = v.findViewById(R.id.textNome);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(" https://api.exchangeratesapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        modeloService = (ModeloService) retrofit.create(ModeloService.class);
        getPosts();

       return v;
    }

    private void getPosts(){
        Call<Modelo> call = modeloService.getModelo();

        call.enqueue(new Callback<Modelo>() {
            @Override
            public void onResponse(Call<Modelo> call, Response<Modelo> response) {
                Modelo modelo = response.body();

                resultado.setText(String.valueOf(modelo.getRates().getAUD()));

            }

            @Override
            public void onFailure(Call<Modelo> call, Throwable t) {

            }
        });
    }

    public String getResultadoSpinner1() {
        return resultadoSpinner1;
    }

    public void setResultadoSpinner1(String resultadoSpinner1) {
        this.resultadoSpinner1 = resultadoSpinner1;
    }

    public String getResultadoSpinner2() {
        return resultadoSpinner2;
    }

    public void setResultadoSpinner2(String resultadoSpinner2) {
        this.resultadoSpinner2 = resultadoSpinner2;
    }

}
