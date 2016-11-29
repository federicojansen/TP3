package com.example.federico.tp3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Nova_roupa2  extends AppCompatActivity {

    EditText nomeRoupa, dataEvento, horaEvento, presentesEvento, enderecoEvento;
    Button button_confirma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nova_roupa2);

        button_confirma = (Button) findViewById(R.id.confirma);
        nomeEvento = (EditText) findViewById(R.id.editText3);
        dataEvento = (EditText) findViewById(R.id.editText4);
        horaEvento = (EditText) findViewById(R.id.editText5);
        presentesEvento = (EditText) findViewById(R.id.editText6);
        enderecoEvento = (EditText) findViewById(R.id.editText7);

        button_confirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventoController crud = new EventoController(getBaseContext());
                String nomeEventoString = nomeEvento.getText().toString();
                String dataEventoString = dataEvento.getText().toString();
                String horaEventoString = horaEvento.getText().toString();
                String presentesEventoString = presentesEvento.getText().toString();
                String enderecoEventoString = enderecoEvento.getText().toString();
                String resultado;

                resultado = crud.insereDado(nomeEventoString, dataEventoString, horaEventoString, presentesEventoString, enderecoEventoString);
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                Intent it = new Intent(Novo_evento.this, MainActivity.class);
                startActivity(it);
            }
        });
    }
}