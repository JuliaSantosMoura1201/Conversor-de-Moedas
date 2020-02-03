package com.julia.conversordemoedas.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.julia.conversordemoedas.model.ModeloService;
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
    private TextView novoValor;
    private TextInputEditText valor;
    private Item item = new Item();
    private float valorRate,  valorRate2;
    private Button buttonConverter;

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

        valor = findViewById(R.id.tietValor);
        novoValor = findViewById(R.id.novoValor);
        buttonConverter = findViewById(R.id.btnConverter);

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

        spinner.setAdapter(configuraAdapter());

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item.setRate(parent.getItemAtPosition(position).toString());
                getBandeira(item.getRate(), 1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void spinnerMoedaDesejada(){

        spinnerMoedaDesejada.setAdapter(configuraAdapter());

        spinnerMoedaDesejada.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item.setRate2(parent.getItemAtPosition(position).toString());
                getBandeira(item.getRate2(), 2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void getBandeira(final String rateSelecionado, final int flag){
        Call<Modelo> call = modeloService.getModelo();

        call.enqueue(new Callback<Modelo>() {
            @Override
            public void onResponse(Call<Modelo> call, Response<Modelo> response) {
                Modelo modelo = response.body();

                float numRate = 0;

                switch (rateSelecionado){
                    case "CAD":
                        numRate = modelo.getRates().getCAD();
                        break;
                    case "HKD":
                        numRate = modelo.getRates().getHKD();
                        break;
                    case "ISK":
                        numRate = modelo.getRates().getISK();
                        break;
                    case "PHP":
                        numRate = modelo.getRates().getPHP();
                        break;
                    case "DKK":
                        numRate = modelo.getRates().getDKK();
                        break;
                    case "HUF":
                        numRate = modelo.getRates().getHUF();
                        break;
                    case "CZK":
                        numRate = modelo.getRates().getCZK();
                        break;
                    case "AUD":
                        numRate = modelo.getRates().getAUD();
                        break;
                    case "RON":
                        numRate = modelo.getRates().getRON();
                        break;
                    case "SEK":
                        numRate = modelo.getRates().getSEK();
                        break;
                    case "IDR":
                        numRate = modelo.getRates().getIDR();
                        break;
                    case "INR":
                        numRate = modelo.getRates().getINR();
                        break;
                    case "BRL":
                        numRate = modelo.getRates().getBRL();
                        break;
                    case "RUB":
                        numRate = modelo.getRates().getRUB();
                        break;
                    case "HRK":
                        numRate = modelo.getRates().getHRK();
                        break;
                    case "JPY":
                        numRate = modelo.getRates().getJPY();
                        break;
                    case "THB":
                        numRate = modelo.getRates().getTHB();
                        break;
                    case "CHF":
                        numRate = modelo.getRates().getCHF();
                        break;
                    case "SGD":
                        numRate = modelo.getRates().getSGD();
                        break;
                    case "PLN":
                        numRate = modelo.getRates().getPLN();
                        break;
                    case "BGN":
                        numRate = modelo.getRates().getBGN();
                        break;
                    case "TRY":
                        numRate = modelo.getRates().getTRY();
                        break;
                    case "CNY":
                        numRate = modelo.getRates().getCNY();
                        break;
                    case "NOK":
                        numRate = modelo.getRates().getNOK();
                        break;
                    case "NZD":
                        numRate = modelo.getRates().getNZD();
                        break;
                    case "ZAR":
                        numRate = modelo.getRates().getZAR();
                        break;
                    case "USD":
                        numRate = modelo.getRates().getUSD();
                        break;
                    case "MXN":
                        numRate = modelo.getRates().getMXN();
                        break;
                    case "ILS":
                        numRate = modelo.getRates().getILS();
                        break;
                    case "GBP":
                        numRate = modelo.getRates().getGBP();
                        break;
                    case "KRW":
                        numRate = modelo.getRates().getKRW();
                        break;
                    case "MYR":
                        numRate = modelo.getRates().getMYR();
                        break;

                }

                if(flag == 1){
                    valorRate = numRate;
                }else{

                    valorRate2 = numRate;
                }

            }

            @Override
            public void onFailure(Call<Modelo> call, Throwable t) {

            }
        });
    }

    public void converter(View view){

        item.setValDig(valor.getText().toString());

        if(!item.getValDig().isEmpty()){
            item.setValFinal(String.valueOf((valorRate2/valorRate)* Float.parseFloat(item.getValDig())));
            novoValor.setText(String.valueOf(item.getValFinal()));
            salvarNoHistorico();
            buttonConverter.setText("Convertido");
        }else{
            Toast.makeText(getApplicationContext(), "Preencha o  valor!", Toast.LENGTH_LONG).show();
        }

    }

    public void abrirHistorico(View view){
        Intent intent = new Intent(getApplicationContext(), HistoricoActivity.class);
        startActivity(intent);
    }

    public void salvarNoHistorico(){
        ConversaoDAO conversaoDAO = new ConversaoDAO(getApplicationContext());
        conversaoDAO.salvar(item);
    }

    public ArrayAdapter configuraAdapter(){
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, mOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        return adapter;
    }


}
