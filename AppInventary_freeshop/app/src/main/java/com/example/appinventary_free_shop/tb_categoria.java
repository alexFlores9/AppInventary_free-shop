package com.example.appinventary_free_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class tb_categoria extends AppCompatActivity implements View.OnClickListener{
    private EditText et_id, et_nombre, et_estado;
    private Button btn_guardar;
    boolean inputEt = false;
    boolean inputEd =  false;
    boolean input1 = false;
    ConexionSQLite conexion = new ConexionSQLite(this);
    Dto datos = new Dto();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tb_categoria);

        et_id=(EditText) findViewById(R.id.et_id_categoria);
        et_nombre =(EditText) findViewById(R.id.et_nom_categoria);
        et_estado = (EditText) findViewById(R.id.et_estado_categoria);
        btn_guardar =(Button)findViewById(R.id.btn_guardar_categoria);

        String senal = "";
        String id_categoria = "";
        String nombre_categoria = "";
        String estado_categoria = "";

        try {
            Intent intent= getIntent();
            Bundle bundle = intent.getExtras();
            if(bundle!=null){
                id_categoria = bundle.getString("id_categoria");
                senal = bundle.getString("senal");
                nombre_categoria = bundle.getString("nombre_categoria");
                estado_categoria = bundle.getString("estado_categoria");

                if(senal.equals("1")){
                    et_id.setText(id_categoria);
                    et_nombre.setText(nombre_categoria);
                    et_estado.setText(estado_categoria);
                }
            }
        }catch (Exception e){

        }
    }

    public void limpiarDatosCategoria(){
        et_id.setText(null);
        et_nombre.setText(null);
        et_estado.setText(null);
        et_id.requestFocus();
    }


    public void campocategoria(View v){
        if(et_id.getText().toString().length()==0){
            et_id.setError("Campo obligatorio");
            inputEt = false;
        }else{
            inputEt = true;
        }
        if (et_nombre.getText().toString().length()==0){
            et_nombre.setError("Campo obligatorio");
            inputEd = false;
        }else{
            inputEd= true;
        }
        if(et_estado.getText().toString().length()==0){
            et_estado.setError("Campo obligatorio");
            input1 = false;
        }else{
            input1 = true;
        }

        if(inputEt && inputEd && input1){
            try{
                datos.setId_categoria(Integer.parseInt(et_id.getText().toString()));
                datos.setNom_categoria(et_nombre.getText().toString());
                datos.setEstado_categoria(Integer.parseInt(et_estado.getText().toString()));

                if(conexion.InertCategoria(datos)){
                    Toast.makeText(this,"Registro agregado exitosamente", Toast.LENGTH_SHORT).show();
                    limpiarDatosCategoria();
                }else{
                    Toast.makeText(getApplicationContext(),"Error. ya existe un registro con\n"+"ID: "+et_id.getText().toString(),Toast.LENGTH_SHORT).show();
                    limpiarDatosCategoria();
                }
            }catch (Exception e){
                Toast.makeText(this,"ERROR, dato ya existente.",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onClick(View view) {

    }
}