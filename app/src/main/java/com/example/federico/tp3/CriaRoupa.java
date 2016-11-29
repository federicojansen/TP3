package com.example.federico.tp3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaRoupa extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "roupas.db";
    public static final String TABELA = "eventos";
    public static final String ID = "_id";
    public static final String NOME_PECA = "nome";
    public static final String CATEGORIA = "categoria";
    public static final String FAVORITA = "favorita";
    private static final int VERSAO = 1;

    public CriaRoupa(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABELA + " ( " +
                ID + " integer primary key autoincrement , " +
                NOME_PECA + " text , " +
                CATEGORIA + " text , " +
                FAVORITA + " text );"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABELA);
        onCreate(db);
    }
}
