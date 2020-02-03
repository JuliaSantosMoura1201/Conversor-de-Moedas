package com.julia.conversordemoedas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.julia.conversordemoedas.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ConversaoDAO implements IConversaoDAO{

    private SQLiteDatabase escreve;
    private SQLiteDatabase le;

    public ConversaoDAO(Context context) {
        DBHelper db = new DBHelper(context);
        escreve = db.getWritableDatabase();
        le = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Item item) {

        ContentValues cv = new ContentValues();
        cv.put("rate", item.getRate());
        cv.put("rate2", item.getRate2());
        cv.put("valDig", item.getValDig());
        cv.put("valFinal", item.getValFinal());

        try {
            escreve.insert(DBHelper.TABELA_HISTORCICO, null, cv);
            Log.i("INFO_CONVERSAODAO", "Conversao salva com sucesso!");
        }catch (Exception e){
            Log.e("INFO_CONVERSAODAO", "Erro ao salvar conversao" + e.getMessage());
        }
        return true;
    }

    @Override
    public boolean atualizar(Item item) {
        return false;
    }

    @Override
    public boolean deletar(Item item) {
        return false;
    }

    @Override
    public List<Item> listar() {
        List<Item> itens = new ArrayList<>();

        String sql = "SELECT * FROM " + DBHelper.TABELA_HISTORCICO + " ;";
        Cursor c = le.rawQuery(sql, null);

        while (c.moveToNext()){
            Item item = new Item();

            Long id = c.getLong(c.getColumnIndex("id"));
            String rate = c.getString(c.getColumnIndex("rate"));
            String rate2 = c.getString(c.getColumnIndex("rate2"));
            String valDig = c.getString(c.getColumnIndex("valDig"));
            String valFinal = c.getString(c.getColumnIndex("valFinal"));


            item.setId(id);
            item.setRate(rate);
            item.setRate2(rate2);
            item.setValDig(valDig);
            item.setValFinal(valFinal);

            Log.i("TESTE_LISTA", item.getRate());
            itens.add(item);
        }

        return itens;
    }
}
