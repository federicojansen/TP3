package com.example.federico.tp3;

import android.content.ContentValues;
import android.content.Context;
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
        String erro = "Erro ao inserir registro";
        String sucesso = "Registro inserido com sucesso";

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
            return erro;
        else
            return sucesso;

    }
}

