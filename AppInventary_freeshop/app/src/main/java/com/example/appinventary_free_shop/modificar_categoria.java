package com.example.appinventary_free_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class modificar_categoria extends AppCompatActivity implements View.OnClickListener {
    private EditText et_id, et_nombre, et_estado;
    private Button btn_actualizar;
    boolean inputEt = false;
    boolean inputEd =  false;
    boolean input1 = false;


    ConexionSQLite conexion = new ConexionSQLite(this);
    Dto datos = new Dto();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_categoria);

        et_id=findViewById(R.id.et_id_categoria);
        et_nombre=findViewById(R.id.et_nom_categoria);
        et_estado=findViewById(R.id.et_estado_categoria);
        btn_actualizar = findViewById(R.id.btn_actualizar_categoria);

        Bundle objeto = getIntent().getExtras();
        Dto dto =   null;
        if (objeto!= null){
            dto=(Dto)objeto.getSerializable("articulo");


            et_id.setText(""+dto.getId_categoria());


        }

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
            String id_categoria =et_id.getText().toString();
            String nom_categoria = et_nombre.getText().toString();
            String estado_categoria = et_estado.getText().toString();

            datos.setId_categoria(Integer.parseInt(id_categoria));
            datos.setNom_categoria(nom_categoria);
            datos.setEstado_categoria(Integer.parseInt(estado_categoria));

            if (conexion.editarcategoria(datos)){
                Toast.makeText(this,"Registro modificado.",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"ERRO.\n El ID especificado, no se que ponerle X'D",Toast.LENGTH_SHORT).show();

            }

        }
    }

    @Override
    public void onClick(View view) {

    }
}