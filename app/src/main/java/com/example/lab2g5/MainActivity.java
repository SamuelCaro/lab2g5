package com.example.lab2g5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import android.view.View;




public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton botonTelito= findViewById(R.id.botonTelito);

        botonTelito.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = getIntent();
                String nombre = intent.getStringExtra("nombre");

                TextView textViewCont = findViewById(R.id.contador);
                String contadorStr = textViewCont.getText().toString();
                int contador = Integer.parseInt(contadorStr);
                contador++;
             //   if (contador == 6){


               // }
                Log.d("contador", "" + contador);

                textViewCont.setText(String.valueOf(contador));

            }


        });
        ArrayList<String> prueba = new ArrayList<>();
        prueba.add("Hola");
        prueba.add("Adios");

        LinearLayout seccionIndustria = (LinearLayout) findViewById(R.id.toDoList);
        for (String industria : INDUSTRIAS) {
            CheckBox opcion = new CheckBox(this);
            opcion.setText(industria);
            opcion.setLayoutParams(
                    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            seccionIndustria.addView(opcion);
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == RESULT_OK){

            List dataFromMessageActivity = data.getStringArrayListExtra("tareas");

        }

    }

    public static String[] INDUSTRIAS ={
            "Arte",
            "Computación",
            "Ingeniería civil",
            "Bioquímica",
            "Música",
            "Astronomía",
            "Zoología"
    };



}