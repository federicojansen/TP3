package com.example.federico.tp3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;

public class RoupaController {
    private SQLiteDatabase db;
    private CriaRoupa roupa;

    public RoupaController(Context context){
        roupa = new CriaRoupa(context);
    }

    public String insereDado(String nome_peca, String categoria, String favorita){
        ContentValues valores;
        long resultado;

        db = roupa.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaRoupa.NOME_PECA, nome_peca);
        valores.put(CriaRoupa.CATEGORIA, categoria);
        valores.put(CriaRoupa.FAVORITA, favorita);

        resultado = db.insert(CriaRoupa.TABELA, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso";

    }

    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos =  {roupa.ID,roupa.NOME_PECA};
        db = roupa.getReadableDatabase();
        cursor = db.query(roupa.TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}


