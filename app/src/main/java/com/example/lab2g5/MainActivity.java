package com.example.lab2g5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> tareas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    public void abrirRegistroTarea(View view){
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putStringArrayListExtra("tareas",tareas);
        int requestCode = 1;
        startActivityForResult(intent,requestCode);
    }

    protected void onActivityResult (int requestCode, int resultCode,@Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            ArrayList<String> tareas = data.getStringArrayListExtra("tareas");
        }

    }



}