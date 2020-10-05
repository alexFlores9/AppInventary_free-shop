package com.example.appinventary_free_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class detalles_productos extends AppCompatActivity {
    private TextView tv_id_producto, tv_nombre_producto, tv_descripcion_producto,tv_stock, tv_precio,
            tv_unidad_de_medida,tv_estado_producto, tv_categoria, tv_fecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_productos);

        tv_id_producto=(TextView)findViewById(R.id.t1);
        tv_nombre_producto=(TextView)findViewById(R.id.t2);
        tv_descripcion_producto=(TextView)findViewById(R.id.t3);
        tv_stock=(TextView)findViewById(R.id.t4);
        tv_precio = (TextView)findViewById(R.id.t5);
        tv_unidad_de_medida =(TextView)findViewById(R.id.t6);
        tv_estado_producto=(TextView)findViewById(R.id.t7);
        tv_categoria=(TextView)findViewById(R.id.t8);
        tv_fecha=(TextView)findViewById(R.id.t9);

        Bundle objeto = getIntent().getExtras();
        Dto dto =   null;

        if(objeto !=null){
            dto =(Dto)objeto.getSerializable("articulo");
            tv_id_producto.setText(""+dto.getId_producto());
            tv_nombre_producto.setText(dto.getNom_producto());
            tv_descripcion_producto.setText(dto.getDes_producto());
            tv_stock.setText(""+dto.getStock());
            tv_precio.setText(""+dto.getPrecio());
            tv_unidad_de_medida.setText(dto.getUnidad_de_medida());
            tv_estado_producto.setText(""+dto.getEstado_producto());
            tv_categoria.setText(""+dto.getCategoria());
            tv_fecha.setText("Fecha de creación: "+getDateTime());


        }

    }

    private String getDateTime(){
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss a", Locale.getDefault());
        Date date = new Date();
        return  dateFormat.format(date);

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