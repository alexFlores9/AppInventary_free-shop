package com.example.appinventary_free_shop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;

public class recyclerview2 extends AppCompatActivity {
    private RecyclerView recycler;
    private Adaptador2 adap;
    ConexionSQLite datos = new ConexionSQLite(recyclerview2.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview2);



        recycler = (RecyclerView)findViewById(R.id.review2);
        // Esta línea mejora el rendimiento, si sabemos que el contenido
        // no va a afectar al tamaño del RecyclerView
        recycler.setHasFixedSize(true);
        // Nuestro RecyclerView usará un linear layout manager
        recycler.setLayoutManager(new LinearLayoutManager(this));
        //adaptadorArticulos = new AdaptadorArticulos(consulta_recyclerView.this,obtenerArticulos());
        adap = new Adaptador2(recyclerview2.this, datos.mostrar2());
        recycler.setAdapter(adap);
    }

}