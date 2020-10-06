package com.example.appinventary_free_shop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class recyclerview extends AppCompatActivity {
    private RecyclerView recycler;
    private Adaptador adaptador;
    ConexionSQLite datos = new ConexionSQLite(recyclerview.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        recycler = (RecyclerView)findViewById(R.id.review);
        // Esta línea mejora el rendimiento, si sabemos que el contenido
        // no va a afectar al tamaño del RecyclerView
        recycler.setHasFixedSize(true);
        // Nuestro RecyclerView usará un linear layout manager
        recycler.setLayoutManager(new LinearLayoutManager(this));
        //adaptadorArticulos = new AdaptadorArticulos(consulta_recyclerView.this,obtenerArticulos());
        adaptador = new Adaptador(recyclerview.this, datos.mostrar());
        recycler.setAdapter(adaptador);
    }
}