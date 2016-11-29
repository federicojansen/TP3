package com.example.federico.tp3;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Nova_roupa2  extends AppCompatActivity {

    Switch favorito;
    TextView categoria;
    EditText nomePeca;
    Button button_confirma, button_option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nova_roupa2);

        button_confirma = (Button) findViewById(R.id.button3);
        button_option = (Button) findViewById(R.id.button2);
        nomePeca = (EditText) findViewById(R.id.editText);
        categoria = (TextView) findViewById(R.id.textView);
        favorito = (Switch) findViewById(R.id.switch1);

        button_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectOption();
            }
        });

        button_confirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RoupaController crud = new RoupaController(getBaseContext());
                String nomePecaString = nomePeca.getText().toString();
                String categoriaString = categoria.getText().toString();
                String favoritaString = "";
                if (favorito.getShowText() == true) {
                    favoritaString = "SIM";
                } else {
                    favoritaString = "NÃO";
                }
                String resultado;

                resultado = crud.insereDado(nomePecaString, categoriaString, favoritaString);
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                Intent it = new Intent(Nova_roupa2.this, MainActivity.class);
                startActivity(it);
            }
        });
    }

    private void selectOption() {

        final CharSequence[] options = {"Topo", "Torso", "Pernas", "Pé", "Acessórios"};
        AlertDialog.Builder builder = new AlertDialog.Builder(Nova_roupa2.this);
        builder.setTitle("Escolha a categoria");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Topo")) {
                    categoria.setText("Topo");
                } else if (options[item].equals("Torso")) {
                    categoria.setText("Torso");
                } else if (options[item].equals("Pernas")) {
                    categoria.setText("Pernas");
                } else if (options[item].equals("Pé")) {
                    categoria.setText("Pé");
                } else if (options[item].equals("Acessórios")) {
                    categoria.setText("Acessórios");
                }
            }
        });
    }
}