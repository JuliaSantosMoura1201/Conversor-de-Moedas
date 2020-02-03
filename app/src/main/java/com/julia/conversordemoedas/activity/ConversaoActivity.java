package com.julia.conversordemoedas.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.julia.conversordemoedas.ModeloService;
import com.julia.conversordemoedas.R;
import com.julia.conversordemoedas.helper.ConversaoDAO;
import com.julia.conversordemoedas.model.Item;
import com.julia.conversordemoedas.model.Modelo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConversaoActivity extends AppCompatActivity {

    private ModeloService modeloService;
    private Spinner spinner, spinnerMoedaDesejada;
    private TextView txtOutput, textMoedaDesejada, novoValor;
    private TextInputEditText valor;
    private Item item = new Item();
    private float valorRate, valorDigF, valorFinal,  valorRate2;

    String[] mOptions = {"CAD", "HKD", "ISK", "PHP", "DKK", "HUF", "CZK", "AUD",
    "RON", "SEK", "IDR", "INR", "BRL", "RUB", "HRK", "JPY", "THB", "CHF", "SGD",
    "PLN", "BGN", "TRY", "CNY", "NOK", "NZD", "ZAR", "USD", "MXN", "ILS", "GBP",
            "KRW", "MYR"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversao);

        spinner = findViewById(R.id.rates_spinner);
        spinnerMoedaDesejada = findViewById(R.id.spinnerMoedaDesejada);
        textMoedaDesejada = findViewById(R.id.textMoedaDesejada);
        txtOutput = findViewById(R.id.textNome);
        valor = findViewById(R.id.textValor);
        novoValor = findViewById(R.id.novoValor);


        spinnerFun();
        spinnerMoedaDesejada();
        configuraRetrofit();

    }

    public void configuraRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(" https://api.exchangeratesapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        modeloService = (ModeloService) retrofit.create(ModeloService.class);
    }


    public void spinnerFun(){
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, mOptions);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(aa);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item.setRate(parent.getItemAtPosition(position).toString());
                txtOutput.setText(item.getRate());
                getBandeira1();
                //Toast.makeText(getApplicationContext(), String.valueOf(bandeira1), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void spinnerMoedaDesejada(){
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, mOptions);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerMoedaDesejada.setAdapter(aa);

        spinnerMoedaDesejada.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item.setRate2(parent.getItemAtPosition(position).toString());
                textMoedaDesejada.setText(item.getRate2());
                getBandeira2();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void getBandeira2(){
        Call<Modelo> call = modeloService.getModelo();

        call.enqueue(new Callback<Modelo>() {
            @Override
            public void onResponse(Call<Modelo> call, Response<Modelo> response) {
                Modelo modelo = response.body();


                switch (item.getRate2()){
                    case "CAD":
                        valorRate2 = modelo.getRates().getCAD();
                        break;
                    case "HKD":
                        valorRate2 = modelo.getRates().getHKD();
                        break;
                    case "ISK":
                        valorRate2 = modelo.getRates().getISK();
                        break;
                    case "PHP":
                        valorRate2 = modelo.getRates().getPHP();
                        break;
                    case "DKK":
                        valorRate2 = modelo.getRates().getDKK();
                        break;
                    case "HUF":
                        valorRate2 = modelo.getRates().getHUF();
                        break;
                    case "CZK":
                        valorRate2 = modelo.getRates().getCZK();
                        break;
                    case "AUD":
                        valorRate2 = modelo.getRates().getAUD();
                        break;
                    case "RON":
                        valorRate2 = modelo.getRates().getRON();
                        break;
                    case "SEK":
                        valorRate2 = modelo.getRates().getSEK();
                        break;
                    case "IDR":
                        valorRate2 = modelo.getRates().getIDR();
                        break;
                    case "INR":
                        valorRate2 = modelo.getRates().getINR();
                        break;
                    case "BRL":
                        valorRate2 = modelo.getRates().getBRL();
                        break;
                    case "RUB":
                        valorRate2 = modelo.getRates().getRUB();
                        break;
                    case "HRK":
                        valorRate2 = modelo.getRates().getHRK();
                        break;
                    case "JPY":
                        valorRate2 = modelo.getRates().getJPY();
                        break;
                    case "THB":
                        valorRate2 = modelo.getRates().getTHB();
                        break;
                    case "CHF":
                        valorRate2 = modelo.getRates().getCHF();
                        break;
                    case "SGD":
                        valorRate2 = modelo.getRates().getSGD();
                        break;
                    case "PLN":
                        valorRate2 = modelo.getRates().getPLN();
                        break;
                    case "BGN":
                        valorRate2 = modelo.getRates().getBGN();
                        break;
                    case "TRY":
                        valorRate2 = modelo.getRates().getTRY();
                        break;
                    case "CNY":
                        valorRate2 = modelo.getRates().getCNY();
                        break;
                    case "NOK":
                        valorRate2 = modelo.getRates().getNOK();
                        break;
                    case "NZD":
                        valorRate2 = modelo.getRates().getNZD();
                        break;
                    case "ZAR":
                        valorRate2 = modelo.getRates().getZAR();
                        break;
                    case "USD":
                        valorRate2 = modelo.getRates().getUSD();
                        break;
                    case "MXN":
                        valorRate2 = modelo.getRates().getMXN();
                        break;
                    case "ILS":
                        valorRate2 = modelo.getRates().getILS();
                        break;
                    case "GBP":
                        valorRate2 = modelo.getRates().getGBP();
                        break;
                    case "KRW":
                        valorRate2 = modelo.getRates().getKRW();
                        break;
                    case "MYR":
                        valorRate2 = modelo.getRates().getMYR();
                        break;

                }

                //txtOutput.setText(String.valueOf(modelo.getRates().getAUD()));

            }


            @Override
            public void onFailure(Call<Modelo> call, Throwable t) {


            }
        });
    }

    private void getBandeira1(){
        Call<Modelo> call = modeloService.getModelo();

        call.enqueue(new Callback<Modelo>() {
            @Override
            public void onResponse(Call<Modelo> call, Response<Modelo> response) {
                Modelo modelo = response.body();


                switch (item.getRate()){
                    case "CAD":
                        valorRate = modelo.getRates().getCAD();
                        break;
                    case "HKD":
                        valorRate = modelo.getRates().getHKD();
                        break;
                    case "ISK":
                        valorRate = modelo.getRates().getISK();
                        break;
                    case "PHP":
                        valorRate = modelo.getRates().getPHP();
                        break;
                    case "DKK":
                        valorRate = modelo.getRates().getDKK();
                        break;
                    case "HUF":
                        valorRate = modelo.getRates().getHUF();
                        break;
                    case "CZK":
                        valorRate = modelo.getRates().getCZK();
                        break;
                    case "AUD":
                        valorRate = modelo.getRates().getAUD();
                        break;
                    case "RON":
                        valorRate = modelo.getRates().getRON();
                        break;
                    case "SEK":
                        valorRate = modelo.getRates().getSEK();
                        break;
                    case "IDR":
                        valorRate = modelo.getRates().getIDR();
                        break;
                    case "INR":
                        valorRate = modelo.getRates().getINR();
                        break;
                    case "BRL":
                        valorRate = modelo.getRates().getBRL();
                        break;
                    case "RUB":
                        valorRate = modelo.getRates().getRUB();
                        break;
                    case "HRK":
                        valorRate = modelo.getRates().getHRK();
                        break;
                    case "JPY":
                        valorRate = modelo.getRates().getJPY();
                        break;
                    case "THB":
                        valorRate = modelo.getRates().getTHB();
                        break;
                    case "CHF":
                        valorRate = modelo.getRates().getCHF();
                        break;
                    case "SGD":
                        valorRate = modelo.getRates().getSGD();
                        break;
                    case "PLN":
                        valorRate = modelo.getRates().getPLN();
                        break;
                    case "BGN":
                        valorRate = modelo.getRates().getBGN();
                        break;
                    case "TRY":
                        valorRate = modelo.getRates().getTRY();
                        break;
                    case "CNY":
                        valorRate = modelo.getRates().getCNY();
                        break;
                    case "NOK":
                        valorRate = modelo.getRates().getNOK();
                        break;
                    case "NZD":
                        valorRate = modelo.getRates().getNZD();
                        break;
                    case "ZAR":
                        valorRate = modelo.getRates().getZAR();
                        break;
                    case "USD":
                        valorRate = modelo.getRates().getUSD();
                        break;
                    case "MXN":
                        valorRate = modelo.getRates().getMXN();
                        break;
                    case "ILS":
                        valorRate = modelo.getRates().getILS();
                        break;
                    case "GBP":
                        valorRate = modelo.getRates().getGBP();
                        break;
                    case "KRW":
                        valorRate = modelo.getRates().getKRW();
                        break;
                    case "MYR":
                        valorRate = modelo.getRates().getMYR();
                        break;

                }

                //txtOutput.setText(String.valueOf(modelo.getRates().getAUD()));

            }


            @Override
            public void onFailure(Call<Modelo> call, Throwable t) {


            }
        });
    }

    public void converter(View view){
        item.setValDig(valor.getText().toString());

        if(!item.getValDig().isEmpty()){
            valorDigF = Float.parseFloat(item.getValDig());
        }else{
            valorDigF = 1f;
        }
        item.setValFinal(String.valueOf((valorRate2/valorRate)*valorDigF));
        novoValor.setText(item.getValFinal());

        ConversaoDAO conversaoDAO = new ConversaoDAO(getApplicationContext());
        conversaoDAO.salvar(item);
    }

    public void abirHistorico(View view){
        Intent intent = new Intent(getApplicationContext(), HistoricoActivity.class);
        startActivity(intent);
    }


}
