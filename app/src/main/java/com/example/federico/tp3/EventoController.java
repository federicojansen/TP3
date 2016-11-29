package com.example.federico.tp3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;

public class EventoController {
    private SQLiteDatabase db;
    private CriarEvento evento;

    public EventoController(Context context){
        evento = new CriarEvento(context);
    }

    public String insereDado(String nome_evento, String data, String hora, String grupos, String endereco){
        ContentValues valores;
        long resultado;

        db = evento.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriarEvento.NOME_EVENTO, nome_evento);
        valores.put(CriarEvento.DATA, data);
        valores.put(CriarEvento.HORA, hora);
        valores.put(CriarEvento.GRUPOS, grupos);
        valores.put(CriarEvento.ENDERECO, endereco);

        resultado = db.insert(CriarEvento.TABELA, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso";

    }

    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos =  {evento.ID,evento.NOME_EVENTO};
        db = evento.getReadableDatabase();
        cursor = db.query(evento.TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}

