package com.example.appinventary_free_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class modificar_categoria extends AppCompatActivity implements View.OnClickListener {
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
        setContentView(R.layout.activity_modificar_categoria);


    }


    public void editar_categoria1(View v){
        if(et_id.getText().toString().length()==0){
            et_id.setError("Campo obligatorio");
            inputEt = false;
        }else{
            inputEt= true;
        }
        if(et_nombre.getText().toString().length()==0){
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

        if(inputEd && inputEt && input1){
            Integer id =Integer.parseInt( et_id.getText().toString());
            String nombre = et_nombre.getText().toString();
            Integer estado = Integer.parseInt(et_estado.getText().toString());

            datos.setId_categoria(id);
            datos.setNom_categoria(nombre);
            datos.setEstado_categoria(estado);

            if (conexion.editarcategoria(datos)){
                Toast.makeText(this,"Registro modificado.",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"Algo ha salido mal\n Vuelve a intentarlo",Toast.LENGTH_SHORT).show();

            }

        }
    }

    @Override
    public void onClick(View view) {

    }
}