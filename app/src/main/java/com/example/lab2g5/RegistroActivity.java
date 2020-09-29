package com.example.lab2g5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        setTitle("Registro");

        Button button = findViewById(R.id.buttonRegistro);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextNombre = findViewById(R.id.editTextNombre);
                EditText editTextApellido = findViewById(R.id.editTextApellido);
                EditText editTextCodigo = findViewById(R.id.editTextCodigo);
                EditText editTextdni = findViewById(R.id.editTextdni);
                EditText editTextpassword = findViewById(R.id.editTextPassword);
                Spinner spinner = findViewById(R.id.spinnerCarrera);

                String nombre = editTextNombre.getText().toString();
                String apellido = editTextApellido.getText().toString();
                String codigo = editTextCodigo.getText().toString();
                String dni = editTextdni.getText().toString();
                String password = editTextpassword.getText().toString();
                String carrera = spinner.getTransitionName().toString();

                if (nombre.isEmpty()){
                    editTextNombre.setError("No puede ser vacío");
                }

                if (apellido.isEmpty()){
                    editTextApellido.setError("No puede ser vacío");
                }

                if (codigo.isEmpty()){
                    editTextCodigo.setError("No puede ser vacío");
                }

                if (dni.isEmpty()){
                    editTextdni.setError("No puede ser vacío");
                }

                if (password.isEmpty()){
                    editTextpassword.setError("No puede ser vacío");
                }

                if(!nombre.isEmpty() && !password.isEmpty() && !apellido.isEmpty() && !codigo.isEmpty() && !dni.isEmpty()  && password.equalsIgnoreCase("S3cr3t306")){

                    try {
                        int cod = Integer.valueOf(codigo);

                        int codvalido = cod / 10000;
                        if (codvalido<= 2017 && codvalido >= 2012){

                            try {

                                int longituddni = dni.length();
                                if (longituddni == 8){
                                    int dniva = Integer.valueOf(dni);

                                    Toast.makeText(RegistroActivity.this, "Ingreso correcto", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
                                    intent.putExtra("nombre", nombre);
                                    intent.putExtra("apellido", apellido);
                                    intent.putExtra("dni", dni);
                                    intent.putExtra("codigo", codigo);
                                    intent.putExtra("spinnerCarrera", carrera);

                                    startActivity(new Intent(RegistroActivity.this, MainActivity.class));
                                    finish();
                                }

                            }catch (NumberFormatException e){
                                editTextdni.setError("dni no válido");
                            }


                        }
                    }catch (NumberFormatException e){
                        editTextCodigo.setError("código no permitido");
                    }


                }else {
                    TextView textView = findViewById(R.id.textViewError);
                    textView.setVisibility(View.VISIBLE);
                }



            }
        });




    }
}