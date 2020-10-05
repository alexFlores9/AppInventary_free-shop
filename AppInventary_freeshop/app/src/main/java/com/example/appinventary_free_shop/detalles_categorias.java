package com.example.appinventary_free_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class detalles_categorias extends AppCompatActivity {
    private TextView tv1, tv2,tv3,tv4;

    ConexionSQLite conexion = new ConexionSQLite(this);
    Dto datos = new Dto();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_categorias);



        tv1= findViewById(R.id.tv_1);
        tv2= findViewById(R.id.tv_2);
        tv3= findViewById(R.id.tv_3);
        tv4= findViewById(R.id.tv_4);

Bundle objeto = getIntent().getExtras();
Dto dto =   null;
        if (objeto!= null){
            dto=(Dto)objeto.getSerializable("articulo");


            tv1.setText(""+dto.getId_categoria());
            tv2.setText(dto.getNom_categoria());
            tv3.setText(""+dto.getEstado_categoria());
            tv4.setText(""+getDateTime());

        }

    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd:hh:mm:ss a", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);

    }

    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK){
            new android.app.AlertDialog.Builder(this)
                    .setIcon(R.drawable.ic_seguro)
                    .setTitle("Warning")
                    .setMessage("Realmente desea ir al inicio?")
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