package com.example.appinventary_free_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

public class consulta_spinner_categoria extends AppCompatActivity {
    private Spinner sp_options;
    private TextView tv_id, tv_nombre_categoria, tv_estado_categoria;

    ConexionSQLite conexion = new ConexionSQLite(this);
    Dto datos = new Dto();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_spinner_categoria);

    }
}