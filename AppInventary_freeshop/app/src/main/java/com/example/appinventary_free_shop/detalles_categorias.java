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
    private Button btn_eliminar;
    boolean btn_elimina_cate=true;
    boolean btn_edita_cate=true;
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
        //btn_eliminar=findViewById(R.id.btn_eliminar_cat);
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

    public void eliminar_categoria(View v){
        if(btn_elimina_cate){
            String id_cat = tv1.getText().toString();
            datos.setId_categoria(Integer.parseInt(id_cat));
            if (conexion.eliminarcategoria(detalles_categorias.this,datos)){
                Toast.makeText(this,":v",Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this,"Algo salió mal",Toast.LENGTH_SHORT).show();
        }
    }

    public void editar_categorias(View v){
        if(btn_edita_cate){
            String id_cat = tv1.getText().toString();
            datos.setId_categoria(Integer.parseInt(id_cat));

        }
    }

    public void editar_categoria (View v){
        Intent intent = new Intent(getApplicationContext(),modificar_categoria.class);
        startActivity(intent);
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