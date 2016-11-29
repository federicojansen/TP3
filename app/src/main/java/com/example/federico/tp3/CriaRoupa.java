package com.example.federico.tp3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaRoupa extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "banco.db";
    private static final String TABELA = "roupas";
    private static final String ID = "_id";
    private static final String NOME_PECA = "nome";
    private static final String CATEGORIA = "categoria";
    private static final String FAVORITA = "favorita";
    private static final int VERSAO = 1;

    public CriaRoupa(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE"+TABELA+"("
                + ID + "integer primary key autoincrement,"
                + NOME_PECA + "text,"
                + CATEGORIA + "text,"
                + FAVORITA + "text"
                +")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABELA);
        onCreate(db);
    }
}
