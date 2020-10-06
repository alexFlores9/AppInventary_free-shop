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
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK){
            new android.app.AlertDialog.Builder(this)
                    .setIcon(R.drawable.ic_seguro)
                    .setTitle("Warning")
                    .setMessage("Realmente desea retroceder!")
                    .setNegativeButton(android.R.string.cancel,null)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}