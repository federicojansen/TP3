package com.example.federico.tp3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriarEvento  extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "eventos.db";
    public static final String TABELA = "eventos";
    public static final String ID = "_id";
    public static final String NOME_EVENTO = "nome";
    public static final String DATA = "data";
    public static final String HORA = "hora";
    public static final String GRUPOS = "grupos";
    public static final String ENDERECO = "endereco";
    private static final int VERSAO = 1;

    public CriarEvento(Context context) {
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABELA + " ( " +
                ID + " integer primary key autoincrement , " +
                NOME_EVENTO + " text , " +
                DATA + " text , " +
                HORA + " text , " +
                GRUPOS + " text , " +
                ENDERECO + " text );"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABELA);
        onCreate(db);
    }
}

