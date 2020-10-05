package com.example.appinventary_free_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class detalles_categorias extends AppCompatActivity implements View.OnClickListener{
    boolean intputEliminar=true;
    ConexionSQLite conexion = new ConexionSQLite(this);
    Dto datos = new Dto();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_categorias);


    }


    public void eliminar_categoria(){

    }
    @Override
    public void onClick(View view) {

    }
}