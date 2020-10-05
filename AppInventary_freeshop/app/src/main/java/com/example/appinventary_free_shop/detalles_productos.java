package com.example.appinventary_free_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        tv_id_producto=(TextView)findViewById(R.id.tv_id_producto);
        tv_nombre_producto=(TextView)findViewById(R.id.tv_nombre_producto);
        tv_descripcion_producto=(TextView)findViewById(R.id.des_producto);
        tv_stock=(TextView)findViewById(R.id.ed_stock_producto);
        tv_precio = (TextView)findViewById(R.id.tv_precio);
        tv_unidad_de_medida =(TextView)findViewById(R.id.tv_unidad_medida);
        tv_estado_producto=(TextView)findViewById(R.id.ed_estado_producto);
        tv_categoria=(TextView)findViewById(R.id.ed_categoria_producto);
        tv_fecha=(TextView)findViewById(R.id.tv_fecha_pro);

        Bundle objeto = getIntent().getExtras();
        Dto dto = null;

        if(objeto !=null){
            dto =(Dto)objeto.getSerializable("tb_producto");
            tv_id_producto.setText(""+dto.getId_producto());
            tv_nombre_producto.setText(dto.getNom_producto());
            tv_descripcion_producto.setText(dto.getDes_producto());
            tv_stock.setText(String.valueOf(dto.getStock()));
            tv_precio.setText(String.valueOf(dto.getPrecio()));
            tv_unidad_de_medida.setText(dto.getUnidad_de_medida());
            tv_estado_producto.setText(String.valueOf(dto.getEstado_producto()));
            tv_categoria.setText(String.valueOf(dto.getCategoria()));
            tv_fecha.setText("Fecha de creación: "+getDateTime());
        }

    }

    private String getDateTime(){
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss a", Locale.getDefault());
        Date date = new Date();
        return  dateFormat.format(date);

    }
}