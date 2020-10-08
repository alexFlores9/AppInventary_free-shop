package com.example.appinventary_free_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class tb_producto extends AppCompatActivity implements View.OnClickListener {
    private EditText ed_id_producto,ed_nombre_producto,ed_descripcion_producto,ed_stock,
            ed_precio, ed_unidad_de_medida,ed_estado_producto,ed_categoria_producto;

    boolean input1=false;
    boolean inputEd=false;

    int resultadoInsert=0;
    private Button btn_guardar_pro;
    boolean Input1 = false;
    boolean Input2 = false;
    boolean Input3 = false;
    boolean Input4 = false;
    boolean Input5 = false;
    boolean Input6 = false;
    boolean Input7 = false;
    boolean Input8 = false;

    ConexionSQLite conexion = new ConexionSQLite(this);
    Dto datos = new Dto();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tb_producto);

        ed_id_producto = (EditText) findViewById(R.id.ed_id_producto);
        ed_nombre_producto = (EditText)findViewById(R.id.ed_nombre_producto);
        ed_descripcion_producto = (EditText)findViewById(R.id.ed_descripcion_producto);
        ed_stock = (EditText)findViewById(R.id.ed_stock_producto);
        ed_precio = (EditText)findViewById(R.id.ed_precio_producto);
        ed_unidad_de_medida = (EditText)findViewById(R.id.ed_unidad_de_medida);
        ed_estado_producto = (EditText)findViewById(R.id.ed_estado_producto);
        ed_categoria_producto=(EditText)findViewById(R.id.ed_categoria_producto);
        btn_guardar_pro = (Button)findViewById(R.id.btn_guardar_producto);

        String senal = "";
        String id_producto = "";
        String nombre_producto = "";
        String descripcion_producto = "";
        String stock_producto = "";
        String precio_producto= "";
        String unidad_de_medida = "";
        String estado_producto ="";
        String categoria_producto = "";

        try {
            Intent intent= getIntent();
            Bundle bundle = intent.getExtras();
            if(bundle!=null){
                id_producto = bundle.getString("id_producto");
                senal = bundle.getString("senal");
                nombre_producto = bundle.getString("nombre_producto");
                descripcion_producto = bundle.getString("descrpcion_producto");
                stock_producto =  bundle.getString("stock_producto");
                precio_producto = bundle.getString("precio_producto");
                unidad_de_medida = bundle.getString("unidad_de_medida");
                estado_producto = bundle.getString("estado_producto");
                categoria_producto = bundle.getString("categoria_producto");

                if(senal.equals("1")){
                    ed_id_producto.setText(id_producto);
                    ed_nombre_producto.setText(nombre_producto);
                    ed_descripcion_producto.setText(descripcion_producto);
                    ed_stock.setText(stock_producto);
                    ed_precio.setText(precio_producto);
                    ed_unidad_de_medida.setText(unidad_de_medida);
                    ed_estado_producto.setText(estado_producto);
                    ed_categoria_producto.setText(categoria_producto);
                }
            }
        }catch (Exception e){

        }
    }
    @Override
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

    public void limpiarDatosProducto(){
        ed_id_producto.setText(null);
        ed_nombre_producto.setText(null);
        ed_descripcion_producto.setText(null);
        ed_stock.setText(null);
        ed_precio.setText(null);
        ed_unidad_de_medida.setText(null);
        ed_estado_producto.setText(null);
        ed_categoria_producto.setText(null);
        ed_id_producto.requestFocus();
    }

    public void campoproducto (View v){
        if(ed_id_producto.getText().toString().length()==0){
            ed_id_producto.setError("Campo obligatorio");
            Input1 = false;
        }else{
            Input1 = true;
        }
        if (ed_nombre_producto.getText().toString().length()==0){
            ed_nombre_producto.setError("Campo obligatorio");
            Input2=false;
        }else{
            Input2 = true;
        }
        if (ed_descripcion_producto.getText().toString().length()==0){
            ed_descripcion_producto.setError("Campo obligatorio");
            Input3 =false;
        }else{
            Input3 = true;
        }
        if(ed_stock.getText().toString().length()==0){
            ed_stock.setError("Campo obligatorio");
            Input4 = false;
        }else{
            Input4 = true;
        }
        if(ed_precio.getText().toString().length()==0){
            ed_precio.setError("Campo obligatorio");
            Input5=false;
        }else{
            Input5=true;
        }
        if(ed_unidad_de_medida.getText().toString().length()==0){
            ed_unidad_de_medida.setError("Campo obligatorio");
            Input6=false;
        }else {
            Input6= true;
        }
        if(ed_estado_producto.getText().toString().length()==0){
            ed_estado_producto.setError("Campo obligatorio");
            Input7=false;
        }else{
            Input7= true;
        }
        if(ed_categoria_producto.getText().toString().length()==0){
            ed_categoria_producto.setError("Campo obligatorio");
            Input8=false;
        }else{
            Input8=true;
        }
        if(Input1 && Input2 && Input3 && Input4 && Input5 && Input6 && Input7 && Input8){
            try{
                datos.setId_producto(Integer.parseInt(ed_id_producto.getText().toString()));
                datos.setNom_producto(ed_nombre_producto.getText().toString());
                datos.setDes_producto(ed_descripcion_producto.getText().toString());
              /*  ed_stock.setText(null);
                ed_precio.setText(null);
                ed_unidad_de_medida.setText(null);
                ed_estado_producto.setText(null);
                ed_categoria_producto.setText(null);*/
                datos.setStock(Double.parseDouble(ed_stock.getText().toString()));
                datos.setPrecio(Double.parseDouble(ed_precio.getText().toString()));
                datos.setUnidad_de_medida(ed_unidad_de_medida.getText().toString());
                datos.setEstado_producto(Integer.parseInt(ed_estado_producto.getText().toString()));
                datos.setCategoria(Integer.parseInt(ed_categoria_producto.getText().toString()));

            if(conexion.InsertTradicionalPro(datos)){
                Toast.makeText(this,"Registro agregado exitosamente", Toast.LENGTH_SHORT).show();
                limpiarDatosProducto();
                }else{
                    Toast.makeText(getApplicationContext(),"Error. ya existe un registro con\n"+"ID: "+ed_id_producto.getText().toString(),Toast.LENGTH_SHORT).show();
                    limpiarDatosProducto();
                }
            }catch (Exception e){
                Toast.makeText(this,"ERROR, dato ya existente.",Toast.LENGTH_SHORT).show();
            }
        }
    }



    public void editar_producto(View v){
        if(ed_id_producto.getText().toString().length()==0){
            ed_id_producto.setError("Campo obligatorio");
            Input1 = false;
        }else{
            Input1 = true;
        }
        if (ed_nombre_producto.getText().toString().length()==0){
            ed_nombre_producto.setError("Campo obligatorio");
            Input2=false;
        }else{
            Input2 = true;
        }
        if (ed_descripcion_producto.getText().toString().length()==0){
            ed_descripcion_producto.setError("Campo obligatorio");
            Input3 =false;
        }else{
            Input3 = true;
        }
        if(ed_stock.getText().toString().length()==0){
            ed_stock.setError("Campo obligatorio");
            Input4 = false;
        }else{
            Input4 = true;
        }
        if(ed_precio.getText().toString().length()==0){
            ed_precio.setError("Campo obligatorio");
            Input5=false;
        }else{
            Input5=true;
        }
        if(ed_unidad_de_medida.getText().toString().length()==0){
            ed_unidad_de_medida.setError("Campo obligatorio");
            Input6=false;
        }else {
            Input6= true;
        }
        if(ed_estado_producto.getText().toString().length()==0){
            ed_estado_producto.setError("Campo obligatorio");
            Input7=false;
        }else{
            Input7= true;
        }
        if(ed_categoria_producto.getText().toString().length()==0){
            ed_categoria_producto.setError("Campo obligatorio");
            Input8=false;
        }else{
            Input8=true;
        }
        if(Input1 && Input2 && Input3 && Input4 && Input5 && Input6 && Input7 && Input8){

            String id_producto = ed_id_producto.getText().toString();
            String nom_producto =ed_nombre_producto.getText().toString();
            String des_producto = ed_descripcion_producto.getText().toString();
            double stock = Double.parseDouble(ed_stock.getText().toString());
            double precio = Double.parseDouble(ed_precio.getText().toString());
            String unidad_de_medida = ed_unidad_de_medida.getText().toString();
            String estado_producto = ed_estado_producto.getText().toString();
            String categoria = ed_categoria_producto.getText().toString();

            datos.setId_producto(Integer.parseInt(id_producto));
            datos.setNom_producto(nom_producto);
            datos.setDes_producto(des_producto);
            datos.setStock(stock);
            datos.setPrecio(precio);
            datos.setUnidad_de_medida(unidad_de_medida);
            datos.setEstado_producto(Integer.parseInt(estado_producto));
            datos.setCategoria(Integer.parseInt(categoria));

            if(conexion.modificaproducto(datos)){
                Toast.makeText(this,"Registro modificado.",Toast.LENGTH_SHORT).show();
            }else {

                Toast.makeText(this,"No se ha encontrado resultados para la busqueda especificada.",Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void borrar_producto (View v){
        if(ed_id_producto.getText().toString().length()==0){
            ed_id_producto.setError("Campo obligatorio");
            input1 = false;
        }else {
            input1 =true;
        }
        if (input1){
            String id_producto = ed_id_producto.getText().toString();
            datos.setId_producto(Integer.parseInt(id_producto));
            if(conexion.eliminarproducto(tb_producto.this,datos)){
                limpiarDatosProducto();
            }else {
                Toast.makeText(this,"No existe un producto von dicho id.",Toast.LENGTH_SHORT).show();

                limpiarDatosProducto();
            }
        }
    }


















       @Override
    public void onClick(View view) {

    }


/*
    public void buscar_producto(){
        if( ed_id_producto.getText().toString().length()==0){
            ed_id_producto.setError("Campo obligatorio");
            input1=false;
        }else{
            input1=true;

        }
        if (input1){
            String id_producto=  ed_id_producto.getText().toString();
            datos.setId_producto(Integer.parseInt(id_producto));
            if (conexion.consultaArticulos(datos)){
                ed_nombre_producto.setText(datos.getNom_producto());
                ed_descripcion_producto.setText(datos.getDes_producto());
                ed_stock.setText(""+datos.getStock());
                ed_precio.setText(""+datos.getPrecio());
                ed_unidad_de_medida.setText(datos.getUnidad_de_medida());
                ed_estado_producto.setText(""+datos.getEstado_producto());
                ed_categoria_producto.setText(""+datos.getCategoria());

            }else {
                Toast.makeText(this, "No existe un articulo con dicho codigo", Toast.LENGTH_SHORT).show();

            }
        }else {
            Toast.makeText(this, "Ingrese el codigo del articulo a buscar", Toast.LENGTH_SHORT).show();
        }
    }

*/

}