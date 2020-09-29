package com.example.lab2g5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Button button = findViewById(R.id.buttonAgregar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editTextNuevaTarea = findViewById(R.id.nuevaTarea);

                String nuevaTarea = editTextNuevaTarea.getText().toString();

                if (nuevaTarea.isEmpty()) {
                    editTextNuevaTarea.setError("No puede ser vacio");
                } else {
                    Intent intent = getIntent();
                    ArrayList<String> tareas = intent.getStringArrayListExtra("tareas");
                    tareas.add(nuevaTarea);
                    intent.putStringArrayListExtra("tareas", tareas);
                    setResult(RESULT_OK, intent);
                    finish();
                }


            }
        });

    }
}