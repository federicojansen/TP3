package com.example.federico.tp3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button_evento, button_gerar, button_roupa, button_listar_roupas, button_listar_eventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_evento = (Button) findViewById(R.id.button_evento);
        button_gerar = (Button) findViewById(R.id.button_gerar);
        button_roupa = (Button) findViewById(R.id.button_roupa);
        button_listar_roupas = (Button) findViewById(R.id.button_listar_roupas);
        button_listar_eventos = (Button) findViewById(R.id.button_listar_eventos);


        /**
         * clique botao gerar roupa
         */
        button_gerar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent it = new Intent(MainActivity.this, CriaRoupa.class);
                startActivity(it);
            }
        });

        /**
         * clique botao adicionar roupa
         */
        button_roupa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent it = new Intent(MainActivity.this, CriaRoupa.class);
                startActivity(it);
            }
        });

        /**
         * clique botao adicionar evento
         */
        button_evento.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent it = new Intent(MainActivity.this, Novo_evento.class);
                startActivity(it);
            }
        });

        /**
         * clique botao listar roupas
         */
        button_listar_roupas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent it = new Intent(MainActivity.this, CriaRoupa.class);
                startActivity(it);
            }
        });

        /**
         * clique botao listar eventos
         */
        button_listar_eventos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent it = new Intent(MainActivity.this, CriaRoupa.class);
                startActivity(it);
            }
        });
    }
}
