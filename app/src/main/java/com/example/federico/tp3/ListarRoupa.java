package com.example.federico.tp3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

/**
 * Created by federico on 29/11/2016.
 */

public class ListarRoupa extends AppCompatActivity {

    Button button_load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_roupas);

        /**
         * clique botao carregar galeria
         */
        button_load.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(
                        Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

              //  startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });
    }
}
















