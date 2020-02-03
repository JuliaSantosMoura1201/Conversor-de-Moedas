package com.julia.conversordemoedas.model;

import com.julia.conversordemoedas.model.Modelo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ModeloService {

    @GET("latest")
    Call<Modelo> getModelo();

}
