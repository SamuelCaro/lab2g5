package com.example.lab2g5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    ArrayList<String> tareas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton botonTelito = findViewById(R.id.botonTelito);
        botonTelito.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){
                Intent intent = getIntent();
                String nombre = intent.getStringExtra("nombre");
                String carrera = intent.getStringExtra("spinnerCarrera");



                TextView textViewCont = findViewById(R.id.contador);
                TextView textViewDesblo = findViewById(R.id.desbloqueo);
                String contadorStr = textViewCont.getText().toString();
                int contador = Integer.parseInt(contadorStr);
                contador++;
                if (contador == 6){

                    textViewDesblo.setVisibility(View.VISIBLE);


                }
                contador=0;
                Log.d("contador", "" + contador);

                textViewCont.setText(String.valueOf(contador));

            }


        });
        ArrayList<String> prueba = new ArrayList<>();
        LinearLayout seccionIndustria = (LinearLayout) findViewById(R.id.toDoList);
        for (String tarea : tareas) {
            CheckBox opcion = new CheckBox(this);
            opcion.setText(tarea);
            opcion.setLayoutParams(
                    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            seccionIndustria.addView(opcion);
        }

        TextView textView = findViewById(R.id.nombreusuario);
        if(tareas.isEmpty()){
            textView.setVisibility(View.VISIBLE);
        }


    }


    public void abrirRegistroTarea(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putStringArrayListExtra("tareas", tareas);
        int requestCode = 1;
        startActivityForResult(intent, requestCode);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            ArrayList<String> tareas = data.getStringArrayListExtra("tareas");
            LinearLayout seccionIndustria = (LinearLayout) findViewById(R.id.toDoList);
            for (String tarea : tareas) {
                CheckBox opcion = new CheckBox(this);
                opcion.setText(tarea);
                opcion.setLayoutParams(
                        new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                seccionIndustria.addView(opcion);
                if(opcion.isChecked()){
                    opcion.setVisibility(View.INVISIBLE);
                }
            }
            TextView textView = findViewById(R.id.nombreusuario);
            if(tareas.isEmpty()){
                textView.setVisibility(View.VISIBLE);
            }else{
                textView.setVisibility(View.INVISIBLE);
            }

        }

    }



}