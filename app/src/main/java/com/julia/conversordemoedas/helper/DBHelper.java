package com.julia.conversordemoedas.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String NOME_DB = "DB_HISTORICO";
    public static String TABELA_HISTORCICO = "historico";

    public DBHelper(Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_HISTORCICO
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "rate TEXT NOT NULL, rate2 TEXT NOT NULL, valDig TEXT NOT NULL, "+
                "valFinal TEXT NOT NULL ); ";

        Log.i("DBHELPER", "onCreate");
        try {
            db.execSQL( sql );
            Log.i("INFO_DB", "Sucesso ao criar tabela");
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela" + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}
